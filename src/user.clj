(ns user
  (:require [clojure.pprint :refer [pprint]]))

(defn get-current-info []
  {:warn-on-reflection
   *warn-on-reflection*

   :thread
   (-> (Thread/currentThread)
       (bean)
       (dissoc :contextClassLoader
               :threadGroup
               :uncaughtExceptionHandler
               :stackTrace
               :state
               :class))})

(def at-ns-load (get-current-info))

(set! *warn-on-reflection* true)

(def after-initial-set (get-current-info))

(defn p []
  (do
    (println "Initial:")
    (pprint at-ns-load)

    (println)
    (println "After initial set:")
    (pprint after-initial-set)

    (println)
    (println "After repl start:")
    (pprint (get-current-info))

    (set! *warn-on-reflection* true)

    (println)
    (println "After setting from repl:")
    (pprint (get-current-info))))
