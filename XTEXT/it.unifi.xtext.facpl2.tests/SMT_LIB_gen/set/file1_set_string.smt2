;#######################
;RECORD DATATYPE with BOTTOM and ERROR
;#######################
(declare-datatypes (U) ((TValue (mk-val (val U)(miss Bool)(err Bool)))))

;#######################
;Set of elements of type T with attached an integer index
;#######################
(define-sort Set (T) (Array Int T)) 
;################### STRING DECLARATIONs #######################
 (declare-datatypes () ((String s_str_25 s_str_24 s_str_23  s_AdditionalStringValue )))
;################### FACPL FUNCTION DECLARATIONs #######################
(define-fun isFalse ((x (TValue Bool))) Bool
	(ite (= x (mk-val false false false)) true false)
)

(define-fun isTrue ((x (TValue Bool))) Bool
	(ite (= x (mk-val true false false)) true false)
)

(define-fun isBool ((x (TValue Bool))) Bool
		(ite (or (isFalse x) (isTrue x))
			true
			false
		)
)

(define-fun isNotBoolValue ((x (TValue Bool))) Bool
		(ite (or (isFalse x) (isTrue x)) 
			false
			(ite (and (not (miss x)) (not (err x)))
				true
				false
			)
		)
)

(define-fun FAnd ((x (TValue Bool)) (y (TValue Bool))) (TValue Bool)
	(ite (and (isTrue x) (isTrue y))
		(mk-val true false false)
		(ite (or (isFalse x) (isFalse y))
			(mk-val false false false)
			(ite (or (err x) (err y))
				(mk-val false false true)
				(mk-val false true false)
			)
		)
	)
)

(define-fun FOr ((x (TValue Bool)) (y (TValue Bool))) (TValue Bool)
	(ite (or (isTrue x) (isTrue y))
		(mk-val true false false)
		(ite (or (err x) (err y))
			(mk-val false false true)
			(ite (or (miss x) (miss y))
				(mk-val false true true)
				(mk-val false false false)
			)
		)
	)
)

(define-fun FNot ((x (TValue Bool))) (TValue Bool)
	(ite (isTrue x)
		(mk-val false false false)
		(ite (isFalse x)
			(mk-val true false false)
			(ite (miss x)
				(mk-val false true false)
				(mk-val false false true)
			)
		)
	)
)
(define-fun equalBool ((x (TValue Bool)) (y (TValue Bool))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun equalInt ((x (TValue Int)) (y (TValue Int))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun equalReal ((x (TValue Real)) (y (TValue Real))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun isValString ((x (TValue String))) Bool
	(ite (and (not (miss x)) (not (err x))) true false)
)

(define-fun equalString ((x (TValue String)) (y (TValue String))) (TValue Bool)
	(ite (and (isValString x) (isValString y))
		(ite (= (val x) (val y))
			(mk-val true false false)
			(mk-val false false false)
		)
		(ite (or (err x) (err y))
			(mk-val false false true)
			(mk-val false true false)
		)
	)
)

(define-fun isValSetString ((x (TValue (Set String)))) Bool
	(ite (and (not (miss x)) (not (err x))) true false)
)

(define-fun inString ((x (TValue String)) (y (TValue (Set String)))) (TValue Bool)
	(ite (or (err x)(err y)) 
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (exists ((i Int))
						(= (val x) (select (val y) i))
				  )
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun isValInt ((x (TValue Int))) Bool
	(ite (and (not (miss x)) (not (err x))) true false)
)

(define-fun lessthanInt ((x (TValue Int)) (y (TValue Int))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (< (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun lessthanorequalInt ((x (TValue Int)) (y (TValue Int))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (<= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun greaterthanInt ((x (TValue Int)) (y (TValue Int))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (> (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun greaterthanorequalInt ((x (TValue Int)) (y (TValue Int))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (>= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun additionInt ((x (TValue Int)) (y (TValue Int))) (TValue Int)
	(ite (and (isValInt x) (isValInt y))
		(mk-val (+ (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0 false true)
			(mk-val 0 true false)
		)
	)
)

(define-fun subtractInt ((x (TValue Int)) (y (TValue Int))) (TValue Int)
	(ite (and (isValInt x) (isValInt y))
		(mk-val (- (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0 false true)
			(mk-val 0 true false)
		)
	)
)


(define-fun multiplyInt ((x (TValue Int)) (y (TValue Int))) (TValue Int)
	(ite (and (isValInt x) (isValInt y))
		(mk-val (* (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0 false true)
			(mk-val 0 true false)
		)
	)
)


(define-fun divideInt ((x (TValue Int)) (y (TValue Int))) (TValue Int)
	(ite (and (isValInt x) (isValInt y))
		(mk-val (div (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0 false true)
			(mk-val 0 true false)
		)
	)
)

(define-fun isValReal ((x (TValue Real))) Bool
	(ite (and (not (miss x)) (not (err x))) true false)
)

(define-fun lessthanReal ((x (TValue Real)) (y (TValue Real))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (< (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun lessthanorequalReal ((x (TValue Real)) (y (TValue Real))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (<= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun greaterthanReal ((x (TValue Real)) (y (TValue Real))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (> (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun greaterthanorequalReal ((x (TValue Real)) (y (TValue Real))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (>= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun additionReal ((x (TValue Real)) (y (TValue Real))) (TValue Real)
	(ite (and (isValReal x) (isValReal y))
		(mk-val (+ (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0.0 false true)
			(mk-val 0.0 true false)
		)
	)
)

(define-fun subtractReal ((x (TValue Real)) (y (TValue Real))) (TValue Real)
	(ite (and (isValReal x) (isValReal y))
		(mk-val (- (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0.0 false true)
			(mk-val 0.0 true false)
		)
	)
)


(define-fun multiplyReal ((x (TValue Real)) (y (TValue Real))) (TValue Real)
	(ite (and (isValReal x) (isValReal y))
		(mk-val (* (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0.0 false true)
			(mk-val 0.0 true false)
		)
	)
)


(define-fun divideReal ((x (TValue Real)) (y (TValue Real))) (TValue Real)
	(ite (and (isValReal x) (isValReal y))
		(mk-val (/ (val x) (val y)) false false)
		(ite (or (err x) (err y))
			(mk-val 0.0 false true)
			(mk-val 0.0 true false)
		)
	)
)
(define-fun isValSetInt ((x (TValue (Set Int)))) Bool
	(ite (and (not (miss x)) (not (err x))) true false)
)

(define-fun isValSetReal ((x (TValue (Set Real)))) Bool
	(ite (and (not (miss x)) (not (err x))) true false)
)

(define-fun isValSetBool ((x (TValue (Set Bool)))) Bool
	(ite (and (not (miss x)) (not (err x))) true false)
)

(define-fun inBool ((x (TValue Bool)) (y (TValue (Set Bool)))) (TValue Bool)
	(ite (or (err x)(err y)) 
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (exists ((i Int))
						(= (val x) (select (val y) i))
				  )
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun inReal ((x (TValue Real)) (y (TValue (Set Real)))) (TValue Bool)
	(ite (or (err x)(err y)) 
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (exists ((i Int))
						(= (val x) (select (val y) i))
				  )
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun inInt ((x (TValue Int)) (y (TValue (Set Int)))) (TValue Bool)
	(ite (or (err x)(err y)) 
		(mk-val false false true)
		(ite (or (miss x) (miss y))
			(mk-val false true false)
			(ite (exists ((i Int))
						(= (val x) (select (val y) i))
				  )
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)
;################################ END DATATYPEs AND FUNCTIONs DECLARATION #############################

;################### ATTRIBUTE DECLARATIONs #######################
(declare-const n_attr/str_2 (TValue Int))
(assert (not (and (miss n_attr/str_2) (err n_attr/str_2))))
 
(declare-const n_attr/str_7 (TValue String))
(assert (not (and (miss n_attr/str_7) (err n_attr/str_7))))
 
(declare-const n_attr/str_5 (TValue Bool))
(assert (not (and (miss n_attr/str_5) (err n_attr/str_5))))
 
(declare-const n_attr/str_12 (TValue Bool))
(assert (not (and (miss n_attr/str_12) (err n_attr/str_12))))
 
(declare-const n_attr/str_11 (TValue String))
(assert (not (and (miss n_attr/str_11) (err n_attr/str_11))))
 
(declare-const n_attr/str_13 (TValue Int))
(assert (not (and (miss n_attr/str_13) (err n_attr/str_13))))
 
;################### CONSTANTs DECLARATIONs #######################
 
(declare-const const_set_1 (TValue (Set Bool)))
(assert (not (miss const_set_1)))
(assert (not (err const_set_1)))
(assert (= (select (val const_set_1) 0) false))
(assert (forall ((i Int))
	 (or 
		 (= (select (val const_set_1) i) false)
	 )
))
 
(declare-const const_set_2 (TValue (Set Int)))
(assert (not (miss const_set_2)))
(assert (not (err const_set_2)))
(assert (= (select (val const_set_2) 0) 174))
(assert (forall ((i Int))
	 (or 
		 (= (select (val const_set_2) i) 174)
	 )
))
 
(declare-const const_67 (TValue Int))
(assert (= (val const_67) 67))
(assert (not (miss const_67))) 
(assert (not (err const_67)))
 
(declare-const const_set_3 (TValue (Set Bool)))
(assert (not (miss const_set_3)))
(assert (not (err const_set_3)))
(assert (= (select (val const_set_3) 0) true))
(assert (forall ((i Int))
	 (or 
		 (= (select (val const_set_3) i) true)
	 )
))
 
(declare-const const_set_4 (TValue (Set String)))
(assert (not (miss const_set_4)))
(assert (not (err const_set_4)))
(assert (= (select (val const_set_4) 0) s_str_23))
(assert (= (select (val const_set_4) 1) s_str_24))
(assert (forall ((i Int))
	 (or 
		 (= (select (val const_set_4) i) s_str_23)
		 (= (select (val const_set_4) i) s_str_24)
	 )
))
 
(declare-const const_str_25 (TValue String))
(assert (= (val const_str_25) s_str_25))
(assert (not (miss const_str_25))) 
(assert (not (err const_str_25)))
 
(declare-const const_str_24 (TValue String))
(assert (= (val const_str_24) s_str_24))
(assert (not (miss const_str_24))) 
(assert (not (err const_str_24)))
 
(declare-const const_str_23 (TValue String))
(assert (= (val const_str_23) s_str_23))
(assert (not (miss const_str_23))) 
(assert (not (err const_str_23)))
;################################ END ATTRIBUTEs AND CONSTANTs DECLARATION #############################
;################### START CONSTRAINT RULE str_20 #######################
;##### Rule Target
(define-fun cns_target_str_20 () (TValue Bool)
	(inBoolean n_attr/str_5 const_set_1)
)
;##### Rule Obligations
(define-fun cns_obl_permit_str_20 ()  Bool
true
)
 
(define-fun cns_obl_deny_str_20 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_str_20_permit () Bool
(and (isTrue cns_target_str_20) cns_obl_permit_str_20)
)
;DENY
(define-fun cns_str_20_deny () Bool
 false 
)
;NOT APP
(define-fun cns_str_20_notApp () Bool
	(or (isFalse cns_target_str_20) (miss cns_target_str_20))
)
;INDET
(define-fun cns_str_20_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_str_20)
				(miss cns_target_str_20)
			)
		)
		(and 
			(isTrue cns_target_str_20)
			(not cns_obl_permit_str_20)
		)
	)
)
;################### END CONSTRAINT RULE str_20 #########################
;################### START CONSTRAINT RULE str_21 #######################
;##### Rule Target
(define-fun cns_target_str_21 () (TValue Bool)
	(inInt n_attr/str_13 const_set_2)
)
;##### Rule Obligations
(define-fun cns_obl_permit_str_21 ()  Bool
true
)
 
(define-fun cns_obl_deny_str_21 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_str_21_permit () Bool
 false 
)
;DENY
(define-fun cns_str_21_deny () Bool
(and (isTrue cns_target_str_21) cns_obl_deny_str_21)
)
;NOT APP
(define-fun cns_str_21_notApp () Bool
	(or (isFalse cns_target_str_21) (miss cns_target_str_21))
)
;INDET
(define-fun cns_str_21_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_str_21)
				(miss cns_target_str_21)
			)
		)
		(and 
			(isTrue cns_target_str_21)
			(not cns_obl_deny_str_21)
		)
	)
)
;################### END CONSTRAINT RULE str_21 #########################
;################### START CONSTRAINT RULE str_22 #######################
;##### Rule Target
(define-fun cns_target_str_22 () (TValue Bool)
	(FAnd (FAnd (FAnd (FAnd (equalInt n_attr/str_2 const_67) (inBoolean n_attr/str_12 const_set_3)) (inBoolean n_attr/str_5 const_set_1)) (inString n_attr/str_7 const_set_4)) (equalString n_attr/str_11 const_str_25))
)
;##### Rule Obligations
(define-fun cns_obl_permit_str_22 ()  Bool
true
)
 
(define-fun cns_obl_deny_str_22 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_str_22_permit () Bool
(and (isTrue cns_target_str_22) cns_obl_permit_str_22)
)
;DENY
(define-fun cns_str_22_deny () Bool
 false 
)
;NOT APP
(define-fun cns_str_22_notApp () Bool
	(or (isFalse cns_target_str_22) (miss cns_target_str_22))
)
;INDET
(define-fun cns_str_22_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_str_22)
				(miss cns_target_str_22)
			)
		)
		(and 
			(isTrue cns_target_str_22)
			(not cns_obl_permit_str_22)
		)
	)
)
;################### END CONSTRAINT RULE str_22 #########################
;################################ TOP-LEVEL POLICY str_19 CONSTRAINTs ###########################
;##### Policy Target
(define-fun cns_target_str_19 () (TValue Bool)	
	(mk-val true false false) 
)
;##### Policy Obligations
(define-fun cns_obl_permit_str_19 ()  Bool
true
)
 
(define-fun cns_obl_deny_str_19 ()  Bool
true
)
 
;##### Policy Combining Algorithm
(define-fun cns_str_19_cmb_str_20str_21_permit () Bool
	 (or 
		 (and cns_str_20_permit cns_str_21_permit)
		 (and cns_str_20_permit cns_str_21_notApp)
		 (and cns_str_20_notApp cns_str_21_permit)
	 )
)

(define-fun cns_str_19_cmb_str_20str_21_deny () Bool
	 (or cns_str_20_deny cns_str_21_deny)
)

(define-fun cns_str_19_cmb_str_20str_21_notApp () Bool
	 (and cns_str_20_notApp cns_str_21_notApp)
)

(define-fun cns_str_19_cmb_str_20str_21_indet () Bool
	 (or 
		 (and cns_str_20_indet (not cns_str_21_deny))
		 (and (not cns_str_20_deny) cns_str_21_indet)
	 )
)

 
(define-fun cns_str_19_cmb_final_permit () Bool
	 (or 
		 (and cns_str_19_cmb_str_20str_21_permit cns_str_22_permit)
		 (and cns_str_19_cmb_str_20str_21_permit cns_str_22_notApp)
		 (and cns_str_19_cmb_str_20str_21_notApp cns_str_22_permit)
	 )
)

(define-fun cns_str_19_cmb_final_deny () Bool
	 (or cns_str_19_cmb_str_20str_21_deny cns_str_22_deny)
)

(define-fun cns_str_19_cmb_final_notApp () Bool
	 (and cns_str_19_cmb_str_20str_21_notApp cns_str_22_notApp)
)

(define-fun cns_str_19_cmb_final_indet () Bool
	 (or 
		 (and cns_str_19_cmb_str_20str_21_indet (not cns_str_22_deny))
		 (and (not cns_str_19_cmb_str_20str_21_deny) cns_str_22_indet)
	 )
)

 
;##### Policy Final Constraints
;PERMIT
(define-fun cns_str_19_permit () Bool
	(and 
		(isTrue cns_target_str_19)
		cns_str_19_cmb_final_permit
		cns_obl_permit_str_19
	)
)
;DENY
(define-fun cns_str_19_deny () Bool
	(and 
		(isTrue cns_target_str_19)
		cns_str_19_cmb_final_deny
		cns_obl_deny_str_19
	)
)
;NOT APP
(define-fun cns_str_19_notApp () Bool
	(or
		(or (isFalse cns_target_str_19) (miss cns_target_str_19))
		(and (isTrue cns_target_str_19) cns_str_19_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_str_19_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_str_19)
				(miss cns_target_str_19)
			)
		)
		(and (isTrue cns_target_str_19) cns_str_19_cmb_final_indet)
		(and 
			(isTrue cns_target_str_19)
			cns_str_19_cmb_final_permit
			(not cns_obl_permit_str_19)
		)
		(and 
			(isTrue cns_target_str_19)
			cns_str_19_cmb_final_deny
			(not cns_obl_deny_str_19)
		)
	)
)
;################### END TOP-LEVEL POLICY str_19 CONSTRAINTs #########################

