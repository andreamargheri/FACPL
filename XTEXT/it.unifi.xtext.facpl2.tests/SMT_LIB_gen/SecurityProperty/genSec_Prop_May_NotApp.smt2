;#######################
;RECORD DATATYPE with BOTTOM and ERROR
;#######################
(declare-datatypes (U) ((TValue (mk-val (val U)(miss Bool)(err Bool)))))

;#######################
;Set of elements of type T with attached an integer index
;#######################
(define-sort Set (T) (Array Int T)) 
;################### STRING DECLARATIONs #######################
 (declare-datatypes () ((String s_read s_Andrea )))
;################### FACPL FUNCTION DECLARATIONs #######################
(define-fun isFalse ((x (TValue Bool))) Bool
	(ite (= x (mk-val false false false)) true false)
)

(define-fun isTrue ((x (TValue Bool))) Bool
	(ite (= x (mk-val true false false)) true false)
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
(declare-const n_subject/id (TValue String))
(assert (not (and (miss n_subject/id) (err n_subject/id))))
 
(declare-const n_action/id (TValue String))
(assert (not (and (miss n_action/id) (err n_action/id))))
 
;################### CONSTANTs DECLARATIONs #######################
 
(declare-const const_read (TValue String))
(assert (= (val const_read) s_read))
(assert (not (miss const_read))) 
(assert (not (err const_read)))
 
(declare-const const_Andrea (TValue String))
(assert (= (val const_Andrea) s_Andrea))
(assert (not (miss const_Andrea))) 
(assert (not (err const_Andrea)))
;################################ END ATTRIBUTEs AND CONSTANTs DECLARATION #############################
;################### START CONSTRAINT RULE r1 #######################
;##### Rule Target
(define-fun cns_target_r1 () (TValue Bool)
	(FAnd (equalString n_action/id const_read) (equalString n_subject/id const_Andrea))
)
;##### Rule Obligations
(define-fun cns_obl_permit_r1 ()  Bool
true
)
 
(define-fun cns_obl_deny_r1 ()  Bool
true
)
 
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
	(or (isFalse cns_target_r1) (miss cns_target_r1))
)
;INDET
(define-fun cns_r1_indet () Bool
	(or 
		(err cns_target_r1)
		(isNotBoolValue cns_target_r1)
		(and 
			(isTrue cns_target_r1)
			(not cns_obl_permit_r1)
		)
	)
)
;################### END CONSTRAINT RULE r1 #########################
;################################ TOP-LEVEL POLICY Name CONSTRAINTs ###########################
;##### Policy Target
(define-fun cns_target_Name () (TValue Bool)	
	(mk-val true false false) 
)
;##### Policy Obligations
(define-fun cns_obl_permit_Name ()  Bool
true
)
 
(define-fun cns_obl_deny_Name ()  Bool
true
)
 
;##### Policy Combining Algorithm
(define-fun cns_Name_cmb_final_permit () Bool
	cns_r1_permit
)

(define-fun cns_Name_cmb_final_deny () Bool
	cns_r1_deny
)

(define-fun cns_Name_cmb_final_notApp () Bool
	cns_r1_notApp
)

(define-fun cns_Name_cmb_final_indet () Bool
	cns_r1_indet
)
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
		(or (isFalse cns_target_Name) (miss cns_target_Name))
		(and (isTrue cns_target_Name) cns_Name_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_Name_indet () Bool
	(or 
		(err cns_target_Name)
		(isNotBoolValue cns_target_Name)
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
;###################### SECURITY PROPERTY #####################
(assert (= (val n_action/id) s_read))
(assert (not (miss n_action/id)))
(assert (not (err n_action/id)))

(assert cns_Name_notApp)

(check-sat)
(get-model)

