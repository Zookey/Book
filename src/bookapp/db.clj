(ns bookapp.db 
  (:require [clojure.java.jdbc :as sql]))

(def connection 
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//127.0.0.1:3306/book"
   :user "admin"
   :password "doboj100"})

(defn create-book [title description isbn author]
  (sql/insert! connection :book [:title :description :isbn :author] [title description isbn author]))

(defn delete-book [id]
 (sql/delete! connection :book
            ["id = ?" id]))

(defn get-all-books []
  (into [] (sql/query connection ["select * from book"])))

(defn get-book-by-id [id]
    (into [] (sql/query connection ["select * from book where id = ?" id])))

(defn update-book [id title description isbn author]
  ;;(update! db :person {:zip 94540} ["zip = ?" 94546])
  (sql/update! connection :book {:id id :title title :description description :isbn isbn :author author} ["id = ?" id]))
