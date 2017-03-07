(ns bloomload.routes.home
  (:require [bloomload.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [base64-clj.core :as base64]
            [clj-ssh.cli :as cli]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn save-file [img_data name]
  (spit (str "/home/ubuntu/portfs/" name) (base64/decode img_data))
  (cli/sftp "sftp.bloomberg.com" :put (str "/home/ubuntu/portfs/" name)  "/" :username "username" :password "password")
  (str name)
)

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/savefile" [img_data img_id name] (save-file img_data name))
  (GET "/about" [] (about-page)))

