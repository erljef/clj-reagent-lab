(defproject clj-reagent-lab "0.1.0-SNAPSHOT"
  :description ""
  :url ""
  :main ^:skip-aot clj-reagent-lab.core
  :target-path "target/%s"
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 ;;ClojureScript
                 [org.clojure/clojurescript "1.7.122"]
                 [reagent "0.6.0-alpha"]
                 [cljs-ajax "0.5.1"]
                 ]
  :plugins [[lein-ring "0.8.13"]
            [lein-figwheel "0.4.1"]
            ]
  :ring {:handler clj-reagent-lab.handler/app}
  :cljsbuild {
              :builds [ { :id "clj-reagent-lab"
                         :source-paths ["src/cljs"]
                         :figwheel true
                         :compiler {:main "clj-reagent-lab.app"
                                    :asset-path "js/out"
                                    :output-to "resources/public/js/app.js"
                                    :output-dir "resources/public/js/out"} } ] }
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]
                        ]}})
