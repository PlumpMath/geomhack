(ns geomhack.core

(:require
 [thi.ng.morphogen.core :as mg]
 [thi.ng.geom.core :as g]
 [thi.ng.geom.core.vector :as v :refer [vec3]]
 [thi.ng.geom.aabb :as a])
(:import
 [thi.ng.morphogen.core BoxNode])
  )

(defn make-stripes
  "Returns a tree which subdivides form into `n` columns and only
  keeps those for whose index the given predicate returns a truthy
  value. If no predicate is given, `even?` is used by default."
  ([n] (make-stripes even? n))
  ([pred n]
     (mg/subdiv :cols n :out (mapv #(if (pred %) {}) (range n)))))
