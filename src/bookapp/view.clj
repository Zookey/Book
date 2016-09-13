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
   [:h1 "Show all books"]
   [:p "Latest books from our store"]
   [:table  {:class "table table-bordered"}
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
  [:div {:class "form-group"} 
   [:h1 "Add book"]
   (form/form-to [:post "/"]
                 (anti-forgery/anti-forgery-field)
                 [:div {:class "form-group"}
                  (form/label "title" "Title: ")
                  (form/text-field {:class "form-control"} "title")]
                 [:div {:class "form-group"}                  
                  (form/label "description" "Description: ")                  
                  (form/text-field {:class "form-control"}  "description")]
                 [:div {:class "form-group"}                  
                  (form/label "isbn" "ISBN: ")                  
                  (form/text-field {:class "form-control"}  "isbn")]
                 [:div {:class "form-group"}                  
                  (form/label "author" "Author: ")                  
                  (form/text-field {:class "form-control"}  "author")]
                 (form/submit-button {:class "btn btn-primary btn-lg btn-block"}  "Add book")
                 [:br])])

(defn index-page [books] 
  (layout/common-layout ""
                        [:div {:class "col-lg-2"}]
                        [:div {:class "col-lg-8"}
                         (display-all-books books)                        
                         (add-book-form)]
                        [:div {:class "col-lg-2"}]   
                        ))


