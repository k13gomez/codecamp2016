(ns codecamp2016.queue
  (:use [amazonica.aws.sqs]))

(defn resolve-queue-url
  [qname]
  (or (find-queue qname)
      (create-queue qname)))

(defn put-message
  [qurl body]
  (send-message qurl body))

(defn get-message
  [qurl]
  (let [rcvd (receive-message :queue-url qurl
                              :max-number-of-messages 1
                              :delete true)]
    (-> rcvd :messages first)))

(def queue
  (delay (resolve-queue-url "codecamp2016")))

