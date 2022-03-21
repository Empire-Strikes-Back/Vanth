(ns Vanth.main
  (:require
   ["electron" :refer [app BrowserWindow crashReporter]]))

(defonce path (js/require "path"))

(defonce stateA (atom nil))
(defonce windowA (atom nil))

(defn window []
  (reset! windowA (BrowserWindow.
                   (clj->js {:width 1600
                             :height 900
                             :webPreferences {:nodeIntegration true}})))
  (.loadURL ^js/electron.BrowserWindow @windowA  (str "file://" (.join path js/__dirname "index.html")))
  (.on ^js/electron.BrowserWindow @windowA "closed" #(reset! windowA nil)))

(defn -main []
  (.on app "window-all-closed" #(when-not (= js/process.platform "darwin")
                                  (.quit app)))
  (.on app "ready" window))