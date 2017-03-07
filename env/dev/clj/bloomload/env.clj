(ns bloomload.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [bloomload.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[bloomload started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[bloomload has shut down successfully]=-"))
   :middleware wrap-dev})
