(ns baglidate.core-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer [pprint]]
            [baglidate.core :refer :all]))

(deftest bag-declaration-test
  (testing "Bag Declaration grammar works as expected"
    (let [parse (bag-declaration-grammar sample-bag-declaration)]
      (is (vector? parse))
      (is (= :bagit-txt (first parse))))))

(deftest payload-manifest-test
  ;; Note: the original Payload Manifest grammar does *not* work.
  ;; Unfortunately, there seems to be a bug in the grammar or Instaparse which
  ;; causes some kind of non-halting process so the negative test cannot be
  ;; provided.
  (testing "FIXED Payload Manifest grammar works as expected"
    (let [pay-man (get-sample-payload-manifest)
          parse ((get-payload-manifest-grammar-fixed) pay-man)]
      (is (vector? parse))
      (is (= :payload-manifest (first parse))))))

(deftest bag-metadata-test
  (testing "Bag Metadata grammar works as expected"
    (let [bag-meta (get-sample-bag-metadata)
          parse ((get-bag-metadata-grammar-fixed) bag-meta)]
      (is (vector? parse))
      (is (= :metadata-set (first parse))))))

(deftest uri-test
  (testing "URI grammar works as expected"
    (let [sample-uri "https://tools.ietf.org/html/rfc3986#appendix-A"
          parse ((get-uri-grammar) sample-uri)]
      (is (vector? parse))
      (is (= :URI (first parse))))))

(deftest fetch-file-test
  (testing "Fetch File grammar works as expected"
    (let [sample-fetch-file (get-sample-fetch-file)
          parse ((get-fetch-file-grammar-fixed) sample-fetch-file)]
      (is (vector? parse))
      (is (= :fetch-file (first parse))))))
