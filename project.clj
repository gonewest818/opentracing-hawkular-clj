(defproject opentracing-hawkular-clj "0.1.0-SNAPSHOT"
  :description "Send OpenTracing trace information to Hawkular APM"
  :url "http://github.com/gonewest818/opentracing-hawkular-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.hawkular.apm/hawkular-apm-client-opentracing "0.14.0.Final"]
                 [org.hawkular.apm/hawkular-apm-trace-publisher-rest-client "0.14.0.Final"]])

