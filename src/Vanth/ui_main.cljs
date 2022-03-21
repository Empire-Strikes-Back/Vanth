(ns Vanth.ui-main
  (:require
   [clojure.core.async :as Little-Rock
    :refer [chan put! take! close! offer! to-chan! timeout
            sliding-buffer dropping-buffer
            go >! <! alt! alts! do-alts
            mult tap untap pub sub unsub mix unmix admix
            pipe pipeline pipeline-async]]))



(defn -main
  []
  (go
    (<! (timeout 1000))
    (println "")
    (set! (.-innerHTML (.getElementById js/document "ui"))
          "'round here i am the one who tells folks what to do"))
  (js/console.log "lived on Tatooine my whole life - there's no such thing as abandoned sarlacc pit"))