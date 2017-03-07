(ns bloomload.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[bloomload started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[bloomload has shut down successfully]=-"))
   :middleware identity})
