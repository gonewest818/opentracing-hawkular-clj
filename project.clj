(defproject org.clojars.gonewest818/opentracing-hawkular-clj "0.1.0-SNAPSHOT"
  :description "Send OpenTracing trace information to Hawkular APM"
  :url "http://github.com/gonewest818/opentracing-hawkular-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.hawkular.apm/hawkular-apm-client-opentracing "0.14.1.Final"]
                 [org.hawkular.apm/hawkular-apm-trace-publisher-rest-client "0.14.1.Final"]]
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :username :env/clojars_username
                                    :password :env/clojars_password}]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]]
                   :plugins [[lein-midje "3.2.1"]
                             [lein-cloverage "1.0.9"]]}})
