(ns opentracing-clj.impl.hawkular-test
  (:require [midje.sweet :refer :all]
            [midje.util :refer [testable-privates]]
            [opentracing-clj.impl.hawkular :refer :all]))

(testable-privates opentracing-clj.impl.hawkular
                   keyword-to-property)

(defn- tracer?
  "for now we will merely check the tracer is of the proper java type"
  [actual]
  (instance? org.hawkular.apm.client.opentracing.APMTracer actual))

(facts "keyword-to-property"
  (fact "converts clojure keyword names to uppercase strings"
    (keyword-to-property :foo) => "FOO"
    (keyword-to-property :foo-bar) => "FOO_BAR"))

(facts "make-hawkular-tracer"
  (fact "with no arguments, makes an APMTracer"
    (make-hawkular-tracer) => tracer?)
  (fact "ignores irrelevant settings"
    (make-hawkular-tracer {:irrelevant-setting nil}) => tracer?)
  (fact "accepts relevant settings"
    (make-hawkular-tracer {:hawkular-apm-uri "http://localhost:8080"}) => tracer?
    (make-hawkular-tracer {:hawkular-apm-username "my-user"}) => tracer?
    (make-hawkular-tracer {:hawkular-apm-password "my-password"}) => tracer?
    (make-hawkular-tracer {:hawkular-apm-log-level "DEBUG"}) => tracer?
    (make-hawkular-tracer {:hawkular-apm-service-name "test-service"}) => tracer?
    (make-hawkular-tracer {:hawkular-apm-buildstamp "1.0.0"}) => tracer?))
