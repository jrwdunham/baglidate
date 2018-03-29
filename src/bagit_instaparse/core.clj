(ns bagit-instaparse.core
  (:require [instaparse.core :as insta]))

(insta/set-default-input-format! :abnf)

;; 7.1. Bag Declaration: bagit.txt

(def sample-bag-declaration
  "BagIt-Version: 1.0\nTag-File-Character-Encoding: UTF-8")

(def bag-declaration-grammar
  (insta/parser (clojure.java.io/resource "bag_declaration.abnf")))

;; 7.2. Payload Manifest: manifest-algorithm.txt

(defn get-sample-payload-manifest
  []
  (slurp
    (clojure.java.io/resource "sample-manifest-sha256.txt")))

(defn get-payload-manifest-grammar
  "This is the original grammar from the BagIt 1.0 draft at commit
  39af3392a6c85f073fbe78648a1638064e9830b2"
  []
  (insta/parser (clojure.java.io/resource "payload_manifest.abnf")))

(defn get-payload-manifest-grammar-fixed
  []
  (insta/parser (clojure.java.io/resource "payload_manifest_fixed.abnf")))
