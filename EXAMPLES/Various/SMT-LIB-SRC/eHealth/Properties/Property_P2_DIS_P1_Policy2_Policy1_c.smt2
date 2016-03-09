;#######################
;RECORD DATATYPE with BOTTOM and ERROR
;#######################
(declare-datatypes (U) ((TValue (mk-val (val U)(miss Bool)(err Bool)))))

;#######################
;Set of elements of type T with attached an integer index
;#######################
(define-sort Set (T) (Array Int T)) 
;################### STRING DECLARATIONs #######################
 (declare-datatypes () ((String s_doctor s_read s_e-Pre-Write s_e-Pre-Read s_pharmacist s_Data_requested_by_unauthorized_subject s_write )))
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
(declare-const n_subject/id (TValue Bool))
(assert (not (and (miss n_subject/id) (err n_subject/id))))
 
(declare-const n_resource/type (TValue Bool))
(assert (not (and (miss n_resource/type) (err n_resource/type))))
 
(declare-const n_action/id (TValue String))
(assert (not (and (miss n_action/id) (err n_action/id))))
 
(declare-const n_system/time (TValue Bool))
(assert (not (and (miss n_system/time) (err n_system/time))))
 
(declare-const n_resource/patient-id.mail (TValue Bool))
(assert (not (and (miss n_resource/patient-id.mail) (err n_resource/patient-id.mail))))
 
(declare-const n_subject/role (TValue String))
(assert (not (and (miss n_subject/role) (err n_subject/role))))
 
(declare-const n_subject/permission (TValue (Set String)))
(assert (not (and (miss n_subject/permission) (err n_subject/permission))))
 
;################### CONSTANTs DECLARATIONs #######################
 
(declare-const const_doctor (TValue String))
(assert (= (val const_doctor) s_doctor))
(assert (not (miss const_doctor))) 
(assert (not (err const_doctor)))
 
(declare-const const_read (TValue String))
(assert (= (val const_read) s_read))
(assert (not (miss const_read))) 
(assert (not (err const_read)))
 
(declare-const const_e-Pre-Write (TValue String))
(assert (= (val const_e-Pre-Write) s_e-Pre-Write))
(assert (not (miss const_e-Pre-Write))) 
(assert (not (err const_e-Pre-Write)))
 
(declare-const const_e-Pre-Read (TValue String))
(assert (= (val const_e-Pre-Read) s_e-Pre-Read))
(assert (not (miss const_e-Pre-Read))) 
(assert (not (err const_e-Pre-Read)))
 
(declare-const const_pharmacist (TValue String))
(assert (= (val const_pharmacist) s_pharmacist))
(assert (not (miss const_pharmacist))) 
(assert (not (err const_pharmacist)))
 
(declare-const const_Data_requested_by_unauthorized_subject (TValue String))
(assert (= (val const_Data_requested_by_unauthorized_subject) s_Data_requested_by_unauthorized_subject))
(assert (not (miss const_Data_requested_by_unauthorized_subject))) 
(assert (not (err const_Data_requested_by_unauthorized_subject)))
 
(declare-const const_write (TValue String))
(assert (= (val const_write) s_write))
(assert (not (miss const_write))) 
(assert (not (err const_write)))
;################################ END ATTRIBUTEs AND CONSTANTs DECLARATION #############################
;################### START CONSTRAINT POLICY SET Policy1 #######################
;################### START CONSTRAINT RULE write #######################
;##### Rule Target
(define-fun cns_target_write () (TValue Bool)
	(FAnd (FAnd (FAnd (equalString n_subject/role const_doctor) (equalString n_action/id const_write)) (inString const_e-Pre-Write n_subject/permission)) (inString const_e-Pre-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_write ()  Bool
true
)
 
(define-fun cns_obl_deny_write ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_write_permit () Bool
(and (isTrue cns_target_write) cns_obl_permit_write)
)
;DENY
(define-fun cns_write_deny () Bool
 false 
)
;NOT APP
(define-fun cns_write_notApp () Bool
	(or (isFalse cns_target_write) (miss cns_target_write))
)
;INDET
(define-fun cns_write_indet () Bool
	(or 
		(err cns_target_write)
		(isNotBoolValue cns_target_write)
		(and 
			(isTrue cns_target_write)
			(not cns_obl_permit_write)
		)
	)
)
;################### END CONSTRAINT RULE write #########################
;################### START CONSTRAINT RULE read #######################
;##### Rule Target
(define-fun cns_target_read () (TValue Bool)
	(FAnd (FAnd (equalString n_subject/role const_doctor) (equalString n_action/id const_read)) (inString const_e-Pre-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_read ()  Bool
true
)
 
(define-fun cns_obl_deny_read ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_read_permit () Bool
(and (isTrue cns_target_read) cns_obl_permit_read)
)
;DENY
(define-fun cns_read_deny () Bool
 false 
)
;NOT APP
(define-fun cns_read_notApp () Bool
	(or (isFalse cns_target_read) (miss cns_target_read))
)
;INDET
(define-fun cns_read_indet () Bool
	(or 
		(err cns_target_read)
		(isNotBoolValue cns_target_read)
		(and 
			(isTrue cns_target_read)
			(not cns_obl_permit_read)
		)
	)
)
;################### END CONSTRAINT RULE read #########################
;################### START CONSTRAINT RULE pha #######################
;##### Rule Target
(define-fun cns_target_pha () (TValue Bool)
	(FAnd (FAnd (equalString n_subject/role const_pharmacist) (equalString n_action/id const_read)) (inString const_e-Pre-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_pha ()  Bool
true
)
 
(define-fun cns_obl_deny_pha ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_pha_permit () Bool
(and (isTrue cns_target_pha) cns_obl_permit_pha)
)
;DENY
(define-fun cns_pha_deny () Bool
 false 
)
;NOT APP
(define-fun cns_pha_notApp () Bool
	(or (isFalse cns_target_pha) (miss cns_target_pha))
)
;INDET
(define-fun cns_pha_indet () Bool
	(or 
		(err cns_target_pha)
		(isNotBoolValue cns_target_pha)
		(and 
			(isTrue cns_target_pha)
			(not cns_obl_permit_pha)
		)
	)
)
;################### END CONSTRAINT RULE pha #########################
;##### Policy Target
(define-fun cns_target_Policy1 () (TValue Bool)	
	(mk-val true false false) 
)
;##### Policy Obligations
(define-fun cns_obl_permit_Policy1 ()  Bool
	 (and (and
 		 (not (miss n_system/time))
		 (not (err n_system/time))
		 (not (miss n_resource/type))
		 (not (err n_resource/type))
		 (not (miss n_subject/id))
		 (not (err n_subject/id))
		 (not (miss n_action/id))
		 (not (err n_action/id))
)
))
 
(define-fun cns_obl_deny_Policy1 ()  Bool
	 (and 	 true true))
 
;##### Policy Combining Algorithm
(define-fun cns_Policy1_cmb_writeread_permit () Bool
	 (or cns_write_permit cns_read_permit)
)

(define-fun cns_Policy1_cmb_writeread_deny () Bool
	 (or 
		 (and cns_write_deny cns_read_deny)
		 (and cns_write_deny cns_read_notApp)
		 (and cns_write_notApp cns_read_deny)
	 )
)

(define-fun cns_Policy1_cmb_writeread_notApp () Bool
	 (and cns_write_notApp cns_read_notApp)
)

(define-fun cns_Policy1_cmb_writeread_indet () Bool
	 (or 
		 (and cns_write_indet (not cns_read_permit))
		 (and (not cns_write_permit) cns_read_indet)
	 )
)

 
(define-fun cns_Policy1_cmb_final_permit () Bool
	 (or cns_Policy1_cmb_writeread_permit cns_pha_permit)
)

(define-fun cns_Policy1_cmb_final_deny () Bool
	 (or 
		 (and cns_Policy1_cmb_writeread_deny cns_pha_deny)
		 (and cns_Policy1_cmb_writeread_deny cns_pha_notApp)
		 (and cns_Policy1_cmb_writeread_notApp cns_pha_deny)
	 )
)

(define-fun cns_Policy1_cmb_final_notApp () Bool
	 (and cns_Policy1_cmb_writeread_notApp cns_pha_notApp)
)

(define-fun cns_Policy1_cmb_final_indet () Bool
	 (or 
		 (and cns_Policy1_cmb_writeread_indet (not cns_pha_permit))
		 (and (not cns_Policy1_cmb_writeread_permit) cns_pha_indet)
	 )
)

 
;##### Policy Constraints
;PERMIT
(define-fun cns_Policy1_permit () Bool
	(and 
		(isTrue cns_target_Policy1)
		cns_Policy1_cmb_final_permit
		cns_obl_permit_Policy1
	)
)
;DENY
(define-fun cns_Policy1_deny () Bool
	(and 
		(isTrue cns_target_Policy1)
		cns_Policy1_cmb_final_deny
		cns_obl_deny_Policy1
	)
)
;NOT APP
(define-fun cns_Policy1_notApp () Bool
	(or
		(or (isFalse cns_target_Policy1) (miss cns_target_Policy1))
		(and (isTrue cns_target_Policy1) cns_Policy1_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_Policy1_indet () Bool
	(or 
		(err cns_target_Policy1)
		(isNotBoolValue cns_target_Policy1)
		(and (isTrue cns_target_Policy1) cns_Policy1_cmb_final_indet)
		(and 
			(isTrue cns_target_Policy1)
			cns_Policy1_cmb_final_permit
			(not cns_obl_permit_Policy1)
		)
		(and 
			(isTrue cns_target_Policy1)
			cns_Policy1_cmb_final_deny
			(not cns_obl_deny_Policy1)
		)
	)
)

;################### END CONSTRAINT POLICY SET Policy1 #########################
;################### START CONSTRAINT RULE denyRule #######################
;##### Rule Target
(define-fun cns_target_denyRule () (TValue Bool)	
	(mk-val true false false) 
)
;##### Rule Obligations
(define-fun cns_obl_permit_denyRule ()  Bool
true
)
 
(define-fun cns_obl_deny_denyRule ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_denyRule_permit () Bool
 false 
)
;DENY
(define-fun cns_denyRule_deny () Bool
(and (isTrue cns_target_denyRule) cns_obl_deny_denyRule)
)
;NOT APP
(define-fun cns_denyRule_notApp () Bool
	(or (isFalse cns_target_denyRule) (miss cns_target_denyRule))
)
;INDET
(define-fun cns_denyRule_indet () Bool
	(or 
		(err cns_target_denyRule)
		(isNotBoolValue cns_target_denyRule)
		(and 
			(isTrue cns_target_denyRule)
			(not cns_obl_deny_denyRule)
		)
	)
)
;################### END CONSTRAINT RULE denyRule #########################
;################################ TOP-LEVEL POLICY Policy2 CONSTRAINTs ###########################
;##### Policy Target
(define-fun cns_target_Policy2 () (TValue Bool)	
	(mk-val true false false) 
)
;##### Policy Obligations
(define-fun cns_obl_permit_Policy2 ()  Bool
	 (and true))
 
(define-fun cns_obl_deny_Policy2 ()  Bool
	 (and (and
 		 (not (miss n_resource/patient-id.mail))
		 (not (err n_resource/patient-id.mail))
		 (not (miss const_Data_requested_by_unauthorized_subject))
		 (not (err const_Data_requested_by_unauthorized_subject))
)
))
 
;##### Policy Combining Algorithm
(define-fun cns_Policy2_cmb_final_permit () Bool
	 (or cns_Policy1_permit cns_denyRule_permit)
)

(define-fun cns_Policy2_cmb_final_deny () Bool
	 (or 
		 (and cns_Policy1_deny cns_denyRule_deny)
		 (and cns_Policy1_deny cns_denyRule_notApp)
		 (and cns_Policy1_notApp cns_denyRule_deny)
	 )
)

(define-fun cns_Policy2_cmb_final_notApp () Bool
	 (and cns_Policy1_notApp cns_denyRule_notApp)
)

(define-fun cns_Policy2_cmb_final_indet () Bool
	 (or 
		 (and cns_Policy1_indet (not cns_denyRule_permit))
		 (and (not cns_Policy1_permit) cns_denyRule_indet)
	 )
)

 
;##### Policy Final Constraints
;PERMIT
(define-fun cns_Policy2_permit () Bool
	(and 
		(isTrue cns_target_Policy2)
		cns_Policy2_cmb_final_permit
		cns_obl_permit_Policy2
	)
)
;DENY
(define-fun cns_Policy2_deny () Bool
	(and 
		(isTrue cns_target_Policy2)
		cns_Policy2_cmb_final_deny
		cns_obl_deny_Policy2
	)
)
;NOT APP
(define-fun cns_Policy2_notApp () Bool
	(or
		(or (isFalse cns_target_Policy2) (miss cns_target_Policy2))
		(and (isTrue cns_target_Policy2) cns_Policy2_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_Policy2_indet () Bool
	(or 
		(err cns_target_Policy2)
		(isNotBoolValue cns_target_Policy2)
		(and (isTrue cns_target_Policy2) cns_Policy2_cmb_final_indet)
		(and 
			(isTrue cns_target_Policy2)
			cns_Policy2_cmb_final_permit
			(not cns_obl_permit_Policy2)
		)
		(and 
			(isTrue cns_target_Policy2)
			cns_Policy2_cmb_final_deny
			(not cns_obl_deny_Policy2)
		)
	)
)
;################### END TOP-LEVEL POLICY Policy2 CONSTRAINTs #########################
;################### START CONSTRAINT RULE write1 #######################
;##### Rule Target
(define-fun cns_target_write1 () (TValue Bool)
	(FAnd (FAnd (FAnd (equalString n_subject/role const_doctor) (equalString n_action/id const_write)) (inString const_e-Pre-Write n_subject/permission)) (inString const_e-Pre-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_write1 ()  Bool
true
)
 
(define-fun cns_obl_deny_write1 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_write1_permit () Bool
(and (isTrue cns_target_write1) cns_obl_permit_write1)
)
;DENY
(define-fun cns_write1_deny () Bool
 false 
)
;NOT APP
(define-fun cns_write1_notApp () Bool
	(or (isFalse cns_target_write1) (miss cns_target_write1))
)
;INDET
(define-fun cns_write1_indet () Bool
	(or 
		(err cns_target_write1)
		(isNotBoolValue cns_target_write1)
		(and 
			(isTrue cns_target_write1)
			(not cns_obl_permit_write1)
		)
	)
)
;################### END CONSTRAINT RULE write1 #########################
;################### START CONSTRAINT RULE read1 #######################
;##### Rule Target
(define-fun cns_target_read1 () (TValue Bool)
	(FAnd (FAnd (equalString n_subject/role const_doctor) (equalString n_action/id const_read)) (inString const_e-Pre-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_read1 ()  Bool
true
)
 
(define-fun cns_obl_deny_read1 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_read1_permit () Bool
(and (isTrue cns_target_read1) cns_obl_permit_read1)
)
;DENY
(define-fun cns_read1_deny () Bool
 false 
)
;NOT APP
(define-fun cns_read1_notApp () Bool
	(or (isFalse cns_target_read1) (miss cns_target_read1))
)
;INDET
(define-fun cns_read1_indet () Bool
	(or 
		(err cns_target_read1)
		(isNotBoolValue cns_target_read1)
		(and 
			(isTrue cns_target_read1)
			(not cns_obl_permit_read1)
		)
	)
)
;################### END CONSTRAINT RULE read1 #########################
;################### START CONSTRAINT RULE pha1 #######################
;##### Rule Target
(define-fun cns_target_pha1 () (TValue Bool)
	(FAnd (FAnd (equalString n_subject/role const_pharmacist) (equalString n_action/id const_read)) (inString const_e-Pre-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_pha1 ()  Bool
true
)
 
(define-fun cns_obl_deny_pha1 ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_pha1_permit () Bool
(and (isTrue cns_target_pha1) cns_obl_permit_pha1)
)
;DENY
(define-fun cns_pha1_deny () Bool
 false 
)
;NOT APP
(define-fun cns_pha1_notApp () Bool
	(or (isFalse cns_target_pha1) (miss cns_target_pha1))
)
;INDET
(define-fun cns_pha1_indet () Bool
	(or 
		(err cns_target_pha1)
		(isNotBoolValue cns_target_pha1)
		(and 
			(isTrue cns_target_pha1)
			(not cns_obl_permit_pha1)
		)
	)
)
;################### END CONSTRAINT RULE pha1 #########################
;################################ TOP-LEVEL POLICY Policy1_c CONSTRAINTs ###########################
;##### Policy Target
(define-fun cns_target_Policy1_c () (TValue Bool)	
	(mk-val true false false) 
)
;##### Policy Obligations
(define-fun cns_obl_permit_Policy1_c ()  Bool
	 (and (and
 		 (not (miss n_system/time))
		 (not (err n_system/time))
		 (not (miss n_resource/type))
		 (not (err n_resource/type))
		 (not (miss n_subject/id))
		 (not (err n_subject/id))
		 (not (miss n_action/id))
		 (not (err n_action/id))
)
))
 
(define-fun cns_obl_deny_Policy1_c ()  Bool
	 (and 	 true true))
 
;##### Policy Combining Algorithm
(define-fun cns_Policy1_c_cmb_write1read1_permit () Bool
	 (or cns_write1_permit cns_read1_permit)
)

(define-fun cns_Policy1_c_cmb_write1read1_deny () Bool
	 (or 
		 (and cns_write1_deny cns_read1_deny)
		 (and cns_write1_deny cns_read1_notApp)
		 (and cns_write1_notApp cns_read1_deny)
	 )
)

(define-fun cns_Policy1_c_cmb_write1read1_notApp () Bool
	 (and cns_write1_notApp cns_read1_notApp)
)

(define-fun cns_Policy1_c_cmb_write1read1_indet () Bool
	 (or 
		 (and cns_write1_indet (not cns_read1_permit))
		 (and (not cns_write1_permit) cns_read1_indet)
	 )
)

 
(define-fun cns_Policy1_c_cmb_final_permit () Bool
	 (or cns_Policy1_c_cmb_write1read1_permit cns_pha1_permit)
)

(define-fun cns_Policy1_c_cmb_final_deny () Bool
	 (or 
		 (and cns_Policy1_c_cmb_write1read1_deny cns_pha1_deny)
		 (and cns_Policy1_c_cmb_write1read1_deny cns_pha1_notApp)
		 (and cns_Policy1_c_cmb_write1read1_notApp cns_pha1_deny)
	 )
)

(define-fun cns_Policy1_c_cmb_final_notApp () Bool
	 (and cns_Policy1_c_cmb_write1read1_notApp cns_pha1_notApp)
)

(define-fun cns_Policy1_c_cmb_final_indet () Bool
	 (or 
		 (and cns_Policy1_c_cmb_write1read1_indet (not cns_pha1_permit))
		 (and (not cns_Policy1_c_cmb_write1read1_permit) cns_pha1_indet)
	 )
)

 
;##### Policy Final Constraints
;PERMIT
(define-fun cns_Policy1_c_permit () Bool
	(and 
		(isTrue cns_target_Policy1_c)
		cns_Policy1_c_cmb_final_permit
		cns_obl_permit_Policy1_c
	)
)
;DENY
(define-fun cns_Policy1_c_deny () Bool
	(and 
		(isTrue cns_target_Policy1_c)
		cns_Policy1_c_cmb_final_deny
		cns_obl_deny_Policy1_c
	)
)
;NOT APP
(define-fun cns_Policy1_c_notApp () Bool
	(or
		(or (isFalse cns_target_Policy1_c) (miss cns_target_Policy1_c))
		(and (isTrue cns_target_Policy1_c) cns_Policy1_c_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_Policy1_c_indet () Bool
	(or 
		(err cns_target_Policy1_c)
		(isNotBoolValue cns_target_Policy1_c)
		(and (isTrue cns_target_Policy1_c) cns_Policy1_c_cmb_final_indet)
		(and 
			(isTrue cns_target_Policy1_c)
			cns_Policy1_c_cmb_final_permit
			(not cns_obl_permit_Policy1_c)
		)
		(and 
			(isTrue cns_target_Policy1_c)
			cns_Policy1_c_cmb_final_deny
			(not cns_obl_deny_Policy1_c)
		)
	)
)
;################### END TOP-LEVEL POLICY Policy1_c CONSTRAINTs #########################
;###################### STRUCTURAL PROPERTY #####################
(echo "--> Check Policy2DIJOINTPolicy1_c... (holds if the following four checks are unsat)")
(echo "...(1/4) Policy2_PERMIT  DIJOINT Policy1_c_PERMIT...(holds if it is unsat)")
 (push)
(assert 
	 (and cns_Policy2_permit cns_Policy1_c_permit)
)

(check-sat)
;(get-model)

(echo "...(2/4) Policy2_PERMIT  DIJOINT Policy1_c_DENY...(holds if it is unsat)")
 (push)
(assert 
	 (and cns_Policy2_permit cns_Policy1_c_deny)
)

(check-sat)
;(get-model)

(echo "...(3/4) Policy2_DENY  DIJOINT Policy1_c_PERMIT...(holds if it is unsat)")
 (push)
(assert 
	 (and cns_Policy2_deny cns_Policy1_c_permit)
)

(check-sat)
;(get-model)

(echo "...(4/4) Policy2_DENY  DIJOINT Policy1_c_DENY...(holds if it is unsat)")
 (push)
(assert 
	 (and cns_Policy2_deny cns_Policy1_c_deny)
)

(check-sat)
;(get-model)

