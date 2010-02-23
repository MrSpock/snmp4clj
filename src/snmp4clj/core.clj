(ns snmp4clj.core
  (:use [snmp4clj.pdu]
        [snmp4clj.target])
  (:import [org.snmp4j PDU]))

(defn snmp-get [session community address version oid]
  (let [pdu (create-pdu version PDU/GET oid)
        tgt (create-target version
              :community community
              :address address)]
    (.send session pdu tgt)))

(defn snmp-get-next [session community address version oid]
  (let [pdu (create-pdu version PDU/GETNEXT oid)
        tgt (create-target version
              :community community
              :address address)]
    (.send session pdu tgt)))

(defn snmp-get-bulk [oid target version]
  (create-pdu version PDU/GETBULK (map oid oid)))

(defn snmp-walk [indice oids target version])
