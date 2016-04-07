(ns clj-reagent-lab.app
  (:require [reagent.core :as r]
            [ajax.core :refer [GET POST]]))

(defonce app-state (r/atom {:greeting "world"}))

(defn page []
  (let [greeting-request (fn [] (POST "/hello" {:params {:user "Derp"}
                                        :handler (fn [response]
                                                   (.log js/console (str "got response " response))
                                                   (swap! app-state assoc :greeting (:greeting response)))
                                        :format :json
                                        :response-format :json
                                        :keywords? true}))]
    (greeting-request)
    (fn []
      [:div
       [:h1 (str "Hello " (:greeting @app-state) "!")]])))

(defn ^:export run []
      (r/render [page]
                (js/document.getElementById "app")))
