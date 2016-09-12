(ns bookapp.core 
  (:use compojure.core
        ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]     
            [ring.util.response :as ring]   
            [bookapp.view :as view]
            [bookapp.db :as db]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            ))

(defn display-all-books []
  (view/index-page (db/get-all-books)))

(defn create-book [title description isbn author]
    (when-not (str/blank? title)
    (db/create-book title description isbn author))
  (ring/redirect "/"))

(defn delete-book [id]
  (when-not (str/blank? id)
    (db/delete-book id))
  (ring/redirect "/"))

(defroutes my_routes
  (GET "/" [] (display-all-books))
  (POST "/" [title description isbn author] (create-book title description isbn author))
  (GET "/delete/:id" [id]  (delete-book id)))

(def app
  (wrap-defaults my_routes site-defaults))
