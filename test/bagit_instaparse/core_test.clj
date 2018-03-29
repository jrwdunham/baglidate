(ns bagit-instaparse.core-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer [pprint]]
            [bagit-instaparse.core :refer :all]))

(deftest bag-declaration-test
  (testing "Bag Declaration grammar works as expected"
    (let [parse (bag-declaration-grammar sample-bag-declaration)]
      (is (vector? parse))
      (is (= :bagit-txt (first parse))))))

(deftest payload-manifest-test
  (testing "FIXED Payload Manifest grammar works as expected"
    (let [p-m (get-sample-payload-manifest)
          parse ((get-payload-manifest-grammar-fixed) p-m)]
      (is (vector? parse))
      (is (= :payload-manifest (first parse))))))
