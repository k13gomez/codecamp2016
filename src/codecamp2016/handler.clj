(ns codecamp2016.handler
  (:require [compojure.api.sweet :refer :all]
            [codecamp2016.queue :as q]
            [ring.util.http-response :refer :all]
            [schema.core :as s]))

(s/defschema QueueMessage
  {:body s/Str})

(def app
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Code Camp 2016"
                    :description "SQS messages"}
             :tags [{:name "api", :description "some apis"}]}}}

    (context "/api" []
             :tags ["api"]
             (context "/sqs"[]
                      (GET "/" []
                           :summary "dequeue a message"
                           (ok (let [{:keys [body]} (q/get-message @q/queue)]
                                 (if body
                                   {:body body}))))

                      (POST "/" []
                            :body [msg QueueMessage]
                            :summary "enqueue a message"
                            (ok (q/put-message @q/queue (msg :body))))))))
