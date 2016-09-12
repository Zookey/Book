(ns bookapp.core 
  (:use compojure.core
        ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]     
            [ring.util.response :as ring]    
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            ))

(defroutes my_routes
  (GET "/" [] "Hello world message"))