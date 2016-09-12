(ns bookapp.layout
  (:use [hiccup.element :only (link-to)])
 (:require [hiccup.page :as h]))

(defn common-layout [header & body]
  (h/html5
    [:head
     [:title "Book"]
     ]
    [:body
     [:div {:class "header"}
      [:h1 {:class "container"} header]]
     [:div {:id "content" :class "container"} body]]))

(defn not-found []
  [:div
   [:h1 "Page Not Found"]
   [:p "We can not found requested page. "]
   (link-to "/" "Back to home")])