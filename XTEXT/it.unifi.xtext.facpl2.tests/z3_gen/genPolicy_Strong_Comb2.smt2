;#######################
;RECORD DATATYPE with BOTTOM and ERROR
;#######################
(declare-datatypes (U) ((TValue (mk-val (val U)(bot Bool)(err Bool)))))

;#######################
;BAG of elements of type T with attached an integer index
;#######################
(define-sort Bag (T) (Array Int T)) 
;################### STRING DECLARATIONs #######################
 (declare-datatypes () ((String s_write s_doctor )))
;################## BAG s

;?????????????????????????


;################### FACPL FUNCTION DECLARATIONs #######################
;####
;AUXILIARY-function Boolean
;####

(define-fun isFalse ((x (TValue Bool))) Bool
	(ite (= x (mk-val false false false)) true false)
)

(define-fun isTrue ((x (TValue Bool))) Bool
	(ite (= x (mk-val true false false)) true false)
)

(define-fun isBool ((x (TValue Bool))) Bool
		(ite (or (isFalse x) (isTrue x)) true false)
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
			(ite (or (bot x) (bot y))
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
			(ite (bot x)
				(mk-val false true false)
				(mk-val false false true)
			)
		)
	)
)
(define-fun equalBool ((x (TValue Bool)) (y (TValue Bool))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
			(mk-val false true false)
			(ite (= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
		)
	)
)

(define-fun isValString ((x (TValue String))) Bool
	(ite (and (not (bot x)) (not (err x))) true false)
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


(define-fun isValInt ((x (TValue Int))) Bool
	(ite (and (not (bot x)) (not (err x))) true false)
)

(define-fun lessthanInt ((x (TValue Int)) (y (TValue Int))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
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
	(ite (and (not (bot x)) (not (err x))) true false)
)

(define-fun lessthanReal ((x (TValue Real)) (y (TValue Real))) (TValue Bool)
	(ite (or (err x) (err y))
		(mk-val false false true)
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
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
		(ite (or (bot x) (bot y))
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
;################################ END DATATYPEs AND FUNCTIONs DECLARATION #############################

;################### ATTRIBUTE DECLARATIONs #######################
(declare-const n_act/type (TValue Int))
(assert (not (and (bot n_act/type) (err n_act/type))))
 
(declare-const n_sub/profile (TValue Int))
(assert (not (and (bot n_sub/profile) (err n_sub/profile))))
 
(declare-const n_act/id (TValue String))
(assert (not (and (bot n_act/id) (err n_act/id))))
 
(declare-const n_sub/id (TValue String))
(assert (not (and (bot n_sub/id) (err n_sub/id))))
 
;################### CONSTANTs DECLARATIONs #######################
(declare-const const_6 (TValue Int))
(assert (= (val const_6) 6))
(assert (not (bot const_6))) 
(assert (not (err const_6))) 
 
(declare-const const_5 (TValue Int))
(assert (= (val const_5) 5))
(assert (not (bot const_5))) 
(assert (not (err const_5))) 
 
(declare-const const_write (TValue String))
(assert (= (val const_write) s_write))
(assert (not (bot const_write))) 
(assert (not (err const_write))) 
 
(declare-const const_doctor (TValue String))
(assert (= (val const_doctor) s_doctor))
(assert (not (bot const_doctor))) 
(assert (not (err const_doctor))) 
 
;################### START CONSTRAINT RULE r1 #######################
;##### Rule Target
(define-fun cns_target_r1 () (TValue Bool)
	(equalString n_act/id const_write)
)
;##### Rule Obligations
(define-fun cns_obl_permit_r1 ()  Bool
	 (and (and
 		 (not (bot(additionInt const_5 n_sub/profile)))		 (not (err(additionInt const_5 n_sub/profile))))
))
 
(define-fun cns_obl_deny_r1 ()  Bool
	 (and 	 true true))
 
;##### Rule Constraints
;PERMIT
(define-fun cns_r1_permit () Bool
(and (isTrue cns_target_r1) cns_obl_permit_r1)
)
;DENY
(define-fun cns_r1_deny () Bool
 false 
)
;NOT APP
(define-fun cns_r1_notApp () Bool
	(or (isFalse cns_target_r1) (bot cns_target_r1))
)
;INDET
(define-fun cns_r1_indet () Bool
	(or 
		(err cns_target_r1)
		(not (isBool cns_target_r1))
		(and 
			(isTrue cns_target_r1)
			(not cns_obl_permit_r1)
		)
	)
)
;################### END CONSTRAINT RULE r1 #########################
;################### START CONSTRAINT RULE r2 #######################
;##### Rule Target
(define-fun cns_target_r2 () (TValue Bool)
	(equalInt n_act/type const_5)
)
;##### Rule Obligations
(define-fun cns_obl_permit_r2 ()  Bool
true
)
 
(define-fun cns_obl_deny_r2 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_r2_permit () Bool
 false 
)
;DENY
(define-fun cns_r2_deny () Bool
(and (isTrue cns_target_r2) cns_obl_deny_r2)
)
;NOT APP
(define-fun cns_r2_notApp () Bool
	(or (isFalse cns_target_r2) (bot cns_target_r2))
)
;INDET
(define-fun cns_r2_indet () Bool
	(or 
		(err cns_target_r2)
		(not (isBool cns_target_r2))
		(and 
			(isTrue cns_target_r2)
			(not cns_obl_deny_r2)
		)
	)
)
;################### END CONSTRAINT RULE r2 #########################
;################### START CONSTRAINT RULE r3 #######################
;##### Rule Target
(define-fun cns_target_r3 () (TValue Bool)
	(equalInt n_act/type const_6)
)
;##### Rule Obligations
(define-fun cns_obl_permit_r3 ()  Bool
true
)
 
(define-fun cns_obl_deny_r3 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_r3_permit () Bool
 false 
)
;DENY
(define-fun cns_r3_deny () Bool
(and (isTrue cns_target_r3) cns_obl_deny_r3)
)
;NOT APP
(define-fun cns_r3_notApp () Bool
	(or (isFalse cns_target_r3) (bot cns_target_r3))
)
;INDET
(define-fun cns_r3_indet () Bool
	(or 
		(err cns_target_r3)
		(not (isBool cns_target_r3))
		(and 
			(isTrue cns_target_r3)
			(not cns_obl_deny_r3)
		)
	)
)
;################### END CONSTRAINT RULE r3 #########################
;################################ TOP-LEVEL POLICY Name CONSTRAINTs ###########################
;##### Policy Target
(define-fun cns_target_Name () (TValue Bool)
	(equalString n_sub/id const_doctor)
)
;##### Policy Obligations
(define-fun cns_obl_permit_Name ()  Bool
true
)
 
(define-fun cns_obl_deny_Name ()  Bool
true
)
 
;##### Policy Combining Algorithm
(define-fun cns_Name_cmb_r1r2_permit () Bool
	 (and cns_r1_permit cns_r2_permit))

(define-fun cns_Name_cmb_r1r2_deny () Bool
	 (and cns_r1_deny cns_r2_deny))

(define-fun cns_Name_cmb_r1r2_notApp () Bool
	 (and cns_r1_notApp cns_r2_notApp)
)

(define-fun cns_Name_cmb_r1r2_indet () Bool
	 (or 
 		 cns_r1_indet cns_r2_indet
		 (and cns_r1_notApp (not cns_r2_notApp))
		 (and (not cns_r1_notApp) cns_r2_notApp)
		 (and cns_r1_permit cns_r2_deny)
		 (and cns_r1_deny cns_r2_permit)
	 ))

 
(define-fun cns_Name_cmb_final_permit () Bool
	 (and cns_Name_cmb_r1r2_permit cns_r3_permit))

(define-fun cns_Name_cmb_final_deny () Bool
	 (and cns_Name_cmb_r1r2_deny cns_r3_deny))

(define-fun cns_Name_cmb_final_notApp () Bool
	 (and cns_Name_cmb_r1r2_notApp cns_r3_notApp)
)

(define-fun cns_Name_cmb_final_indet () Bool
	 (or 
 		 cns_Name_cmb_r1r2_indet cns_r3_indet
		 (and cns_Name_cmb_r1r2_notApp (not cns_r3_notApp))
		 (and (not cns_Name_cmb_r1r2_notApp) cns_r3_notApp)
		 (and cns_Name_cmb_r1r2_permit cns_r3_deny)
		 (and cns_Name_cmb_r1r2_deny cns_r3_permit)
	 ))

 
;##### Policy Final Constraints
;PERMIT
(define-fun cns_Name_permit () Bool
	(and 
		(isTrue cns_target_Name)
		cns_Name_cmb_final_permit
		cns_obl_permit_Name
	)
)
;DENY
(define-fun cns_Name_deny () Bool
	(and 
		(isTrue cns_target_Name)
		cns_Name_cmb_final_deny
		cns_obl_deny_Name
	)
)
;NOT APP
(define-fun cns_Name_notApp () Bool
	(or
		(or (isFalse cns_target_Name) (bot cns_target_Name))
		(and (isTrue cns_target_Name) cns_Name_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_Name_indet () Bool
	(or 
		(err cns_target_Name)
		(not (isBool cns_target_Name))
		(and (isTrue cns_target_Name) cns_Name_cmb_final_indet)
		(and 
			(isTrue cns_target_Name)
			cns_Name_cmb_final_permit
			(not cns_obl_permit_Name)
		)
		(and 
			(isTrue cns_target_Name)
			cns_Name_cmb_final_deny
			(not cns_obl_deny_Name)
		)
	)
)
;################### END TOP-LEVEL POLICY Name CONSTRAINTs #########################

