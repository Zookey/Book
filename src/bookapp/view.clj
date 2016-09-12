(ns bookapp.view 
  (:use hiccup.page hiccup.element)
  (:require 
    [hiccup.core :refer [h]]
    [hiccup.form :as form]
    [clojure.string :as str]
    [bookapp.layout :as layout]
    [ring.util.anti-forgery :as anti-forgery]))


(defn display-all-books [books]
  [:div 
   [:table 
    [:th "id"]
    [:th "title"]
    [:th "description"]
    [:th "isbn"]
    [:th "author"]
     [:th "delete"]
     [:th "update"]
     (map 
       (fn [book]
         [:tr 
          [:td (h (:id book))]
          [:td (h (:title book))]
          [:td (h (:description book))]
          [:td (h (:isbn book))]
          [:td (h (:author book))]
          [:td [:a {:href (str "/delete/" (h (:id book)))} "delete"]]
          [:td [:a {:href (str "/update/" (h (:id book)))} "update"]]
          ]) books)]])

(defn add-book-form []
  [:div (form/form-to [:post "/"]
                      (anti-forgery/anti-forgery-field)
                      (form/label "title" "Title: ")
                      [:br]
                      (form/text-field "title")
                      [:br]
                      (form/label "description" "Description: ")
                      [:br]
                      (form/text-field "description")
                      [:br]
                      (form/label "isbn" "ISBN: ")
                      [:br]
                      (form/text-field "isbn")
                      [:br]
                      (form/label "author" "Author: ")
                      [:br]
                      (form/text-field "author")
                      [:br]
                      [:br]
                      (form/submit-button "Add book")
                      [:br])])

(defn index-page [books] 
  (layout/common-layout "Books"
                        (display-all-books books)                        
                        (add-book-form)
                        ))


