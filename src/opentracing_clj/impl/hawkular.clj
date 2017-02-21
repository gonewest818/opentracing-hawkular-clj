(ns opentracing-clj.impl.hawkular
  (:import [org.hawkular.apm.client.opentracing APMTracer]))


;; https://hawkular.gitbooks.io/hawkular-apm-user-guide/content/quickstart/
;; http://javadoc.io/doc/io.opentracing/opentracing-api/0.20.7


(defn- keyword-to-property
  "Utility function to convert a keyword to a property name"
  [keyword]
  (-> keyword
      name
      clojure.string/upper-case
      (clojure.string/replace "-" "_")))


(defn make-hawkular-tracer
  "Create Hawkular APMTracer using optional settings in a hash-map:
  {
    :hawkular-apm-uri          \"http://localhost:8080\"
    :hawkular-apm-username     \"jdoe\"
    :hawkular-apm-password     \"password\"
    :hawkular-apm-log-level    \"INFO\"
    :hawkular-apm-service-name \"my-service-name\"
    :hawkular-apm-buildstamp   \"1.0.0\"
  }
  
  Where any settings provided here will be set explicitly as
  system properties, and will therefore override any variables
  or properties set elsewhere in the environment.
  
  This implementation will select the aforementioned keywords
  out of a hash-map containing other unrelated keys; we do this
  so the caller can directly pass a map produced by weavejester's
  \"environ\".

  The resulting tracer implements the opentracing.io Tracer interface
  and can therefore be used in any application instrumented with
  opentracting-clj."

  ([] (APMTracer.))
  ([settings]
   (doseq [k [:hawkular-apm-uri
              :hawkular-apm-username
              :hawkular-apm-password
              :hawkular-apm-log-level
              :hawkular-apm-service-name
              :hawkular-apm-buildstamp]]
     (if-let [v (settings k)]
       (System/setProperty (keyword-to-property k) v)))
   (APMTracer.)))
