(ns bookapp.handler
  (:require [compojure.core :refer [defroutes ANY]]
            [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [bookapp.layout :as layout]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [bookapp.core :as core]
            ))

(defroutes routes
  core/my_routes
  (route/resources "/")
  )


(def app
  (wrap-defaults routes site-defaults))
