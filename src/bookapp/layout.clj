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
  (common "NOT FOUND" [:div {:id "error"} "The page you requested could not be found"]))