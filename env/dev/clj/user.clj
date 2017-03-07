(ns user
  (:require [mount.core :as mount]
            bloomload.core))

(defn start []
  (mount/start-without #'bloomload.core/http-server
                       #'bloomload.core/repl-server))

(defn stop []
  (mount/stop-except #'bloomload.core/http-server
                     #'bloomload.core/repl-server))

(defn restart []
  (stop)
  (start))


