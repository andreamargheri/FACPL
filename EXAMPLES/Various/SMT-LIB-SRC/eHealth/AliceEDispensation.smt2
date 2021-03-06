;#######################
;RECORD DATATYPE with BOTTOM and ERROR
;#######################
(declare-datatypes (U) ((TValue (mk-val (val U)(miss Bool)(err Bool)))))

;#######################
;Set of elements of type T with attached an integer index
;#######################
(define-sort Set (T) (Array Int T)) 
;################### STRING DECLARATIONs #######################
 (declare-datatypes () ((String s_doctor s_e-Dis-Read s_read s_Alice s_e-Dispensation s_pharmacist s_e-Dis-Write s_write s_Data_request_by_unauthorised_subject  s_AdditionalStringValue )))
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
(declare-const n_subject/id (TValue Bool))
(assert (not (and (miss n_subject/id) (err n_subject/id))))
 
(declare-const n_resource/type (TValue String))
(assert (not (and (miss n_resource/type) (err n_resource/type))))
 
(declare-const n_action/id (TValue String))
(assert (not (and (miss n_action/id) (err n_action/id))))
 
(declare-const n_system/time (TValue Bool))
(assert (not (and (miss n_system/time) (err n_system/time))))
 
(declare-const n_subject/role (TValue String))
(assert (not (and (miss n_subject/role) (err n_subject/role))))
 
(declare-const n_subject/permission (TValue (Set String)))
(assert (not (and (miss n_subject/permission) (err n_subject/permission))))
 
(declare-const n_resource/patient-id (TValue String))
(assert (not (and (miss n_resource/patient-id) (err n_resource/patient-id))))
 
(declare-const n_resource/patient-mail (TValue Bool))
(assert (not (and (miss n_resource/patient-mail) (err n_resource/patient-mail))))
 
;################### CONSTANTs DECLARATIONs #######################
 
(declare-const const_doctor (TValue String))
(assert (= (val const_doctor) s_doctor))
(assert (not (miss const_doctor))) 
(assert (not (err const_doctor)))
 
(declare-const const_e-Dis-Read (TValue String))
(assert (= (val const_e-Dis-Read) s_e-Dis-Read))
(assert (not (miss const_e-Dis-Read))) 
(assert (not (err const_e-Dis-Read)))
 
(declare-const const_read (TValue String))
(assert (= (val const_read) s_read))
(assert (not (miss const_read))) 
(assert (not (err const_read)))
 
(declare-const const_Alice (TValue String))
(assert (= (val const_Alice) s_Alice))
(assert (not (miss const_Alice))) 
(assert (not (err const_Alice)))
 
(declare-const const_e-Dispensation (TValue String))
(assert (= (val const_e-Dispensation) s_e-Dispensation))
(assert (not (miss const_e-Dispensation))) 
(assert (not (err const_e-Dispensation)))
 
(declare-const const_pharmacist (TValue String))
(assert (= (val const_pharmacist) s_pharmacist))
(assert (not (miss const_pharmacist))) 
(assert (not (err const_pharmacist)))
 
(declare-const const_e-Dis-Write (TValue String))
(assert (= (val const_e-Dis-Write) s_e-Dis-Write))
(assert (not (miss const_e-Dis-Write))) 
(assert (not (err const_e-Dis-Write)))
 
(declare-const const_write (TValue String))
(assert (= (val const_write) s_write))
(assert (not (miss const_write))) 
(assert (not (err const_write)))
 
(declare-const const_Data_request_by_unauthorised_subject (TValue String))
(assert (= (val const_Data_request_by_unauthorised_subject) s_Data_request_by_unauthorised_subject))
(assert (not (miss const_Data_request_by_unauthorised_subject))) 
(assert (not (err const_Data_request_by_unauthorised_subject)))
;################################ END ATTRIBUTEs AND CONSTANTs DECLARATION #############################
 
;################### START CONSTRAINT POLICY SET eDis #######################
;################### START CONSTRAINT RULE writeDis #######################
;##### Rule Target
(define-fun cns_target_writeDis () (TValue Bool)
	(FAnd (FAnd (FAnd (equalString n_subject/role const_doctor) (equalString n_action/id const_write)) (inString const_e-Dis-Write n_subject/permission)) (inString const_e-Dis-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_writeDis ()  Bool
true
)
 
(define-fun cns_obl_deny_writeDis ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_writeDis_permit () Bool
(and (isTrue cns_target_writeDis) cns_obl_permit_writeDis)
)
;DENY
(define-fun cns_writeDis_deny () Bool
 false 
)
;NOT APP
(define-fun cns_writeDis_notApp () Bool
	(or (isFalse cns_target_writeDis) (miss cns_target_writeDis))
)
;INDET
(define-fun cns_writeDis_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_writeDis)
				(miss cns_target_writeDis)
			)
		)
		(and 
			(isTrue cns_target_writeDis)
			(not cns_obl_permit_writeDis)
		)
	)
)
;################### END CONSTRAINT RULE writeDis #########################
;################### START CONSTRAINT RULE readDis #######################
;##### Rule Target
(define-fun cns_target_readDis () (TValue Bool)
	(FAnd (FAnd (equalString n_subject/role const_doctor) (equalString n_action/id const_read)) (inString const_e-Dis-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_readDis ()  Bool
true
)
 
(define-fun cns_obl_deny_readDis ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_readDis_permit () Bool
(and (isTrue cns_target_readDis) cns_obl_permit_readDis)
)
;DENY
(define-fun cns_readDis_deny () Bool
 false 
)
;NOT APP
(define-fun cns_readDis_notApp () Bool
	(or (isFalse cns_target_readDis) (miss cns_target_readDis))
)
;INDET
(define-fun cns_readDis_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_readDis)
				(miss cns_target_readDis)
			)
		)
		(and 
			(isTrue cns_target_readDis)
			(not cns_obl_permit_readDis)
		)
	)
)
;################### END CONSTRAINT RULE readDis #########################
;################### START CONSTRAINT RULE phaDis #######################
;##### Rule Target
(define-fun cns_target_phaDis () (TValue Bool)
	(FAnd (FAnd (equalString n_subject/role const_pharmacist) (equalString n_action/id const_read)) (inString const_e-Dis-Read n_subject/permission))
)
;##### Rule Obligations
(define-fun cns_obl_permit_phaDis ()  Bool
true
)
 
(define-fun cns_obl_deny_phaDis ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_phaDis_permit () Bool
(and (isTrue cns_target_phaDis) cns_obl_permit_phaDis)
)
;DENY
(define-fun cns_phaDis_deny () Bool
 false 
)
;NOT APP
(define-fun cns_phaDis_notApp () Bool
	(or (isFalse cns_target_phaDis) (miss cns_target_phaDis))
)
;INDET
(define-fun cns_phaDis_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_phaDis)
				(miss cns_target_phaDis)
			)
		)
		(and 
			(isTrue cns_target_phaDis)
			(not cns_obl_permit_phaDis)
		)
	)
)
;################### END CONSTRAINT RULE phaDis #########################
;##### Policy Target
(define-fun cns_target_eDis () (TValue Bool)
	(equalString const_e-Dispensation n_resource/type)
)
;##### Policy Obligations
(define-fun cns_obl_permit_eDis ()  Bool
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
 
(define-fun cns_obl_deny_eDis ()  Bool
	 (and 	 true true))
 
;##### Policy Combining Algorithm
(define-fun cns_eDis_cmb_writeDisreadDis_permit () Bool
	 (or cns_writeDis_permit cns_readDis_permit)
)

(define-fun cns_eDis_cmb_writeDisreadDis_deny () Bool
	 (or 
		 (and cns_writeDis_deny cns_readDis_deny)
		 (and cns_writeDis_deny cns_readDis_notApp)
		 (and cns_writeDis_notApp cns_readDis_deny)
	 )
)

(define-fun cns_eDis_cmb_writeDisreadDis_notApp () Bool
	 (and cns_writeDis_notApp cns_readDis_notApp)
)

(define-fun cns_eDis_cmb_writeDisreadDis_indet () Bool
	 (or 
		 (and cns_writeDis_indet (not cns_readDis_permit))
		 (and (not cns_writeDis_permit) cns_readDis_indet)
	 )
)

 
(define-fun cns_eDis_cmb_final_permit () Bool
	 (or cns_eDis_cmb_writeDisreadDis_permit cns_phaDis_permit)
)

(define-fun cns_eDis_cmb_final_deny () Bool
	 (or 
		 (and cns_eDis_cmb_writeDisreadDis_deny cns_phaDis_deny)
		 (and cns_eDis_cmb_writeDisreadDis_deny cns_phaDis_notApp)
		 (and cns_eDis_cmb_writeDisreadDis_notApp cns_phaDis_deny)
	 )
)

(define-fun cns_eDis_cmb_final_notApp () Bool
	 (and cns_eDis_cmb_writeDisreadDis_notApp cns_phaDis_notApp)
)

(define-fun cns_eDis_cmb_final_indet () Bool
	 (or 
		 (and cns_eDis_cmb_writeDisreadDis_indet (not cns_phaDis_permit))
		 (and (not cns_eDis_cmb_writeDisreadDis_permit) cns_phaDis_indet)
	 )
)

 
;##### Policy Constraints
;PERMIT
(define-fun cns_eDis_permit () Bool
	(and 
		(isTrue cns_target_eDis)
		cns_eDis_cmb_final_permit
		cns_obl_permit_eDis
	)
)
;DENY
(define-fun cns_eDis_deny () Bool
	(and 
		(isTrue cns_target_eDis)
		cns_eDis_cmb_final_deny
		cns_obl_deny_eDis
	)
)
;NOT APP
(define-fun cns_eDis_notApp () Bool
	(or
		(or (isFalse cns_target_eDis) (miss cns_target_eDis))
		(and (isTrue cns_target_eDis) cns_eDis_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_eDis_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_eDis)
				(miss cns_target_eDis)
			)
		)
		(and (isTrue cns_target_eDis) cns_eDis_cmb_final_indet)
		(and 
			(isTrue cns_target_eDis)
			cns_eDis_cmb_final_permit
			(not cns_obl_permit_eDis)
		)
		(and 
			(isTrue cns_target_eDis)
			cns_eDis_cmb_final_deny
			(not cns_obl_deny_eDis)
		)
	)
)

;################### END CONSTRAINT POLICY SET eDis #########################
;################### START CONSTRAINT RULE ruleDeny #######################
;##### Rule Target
(define-fun cns_target_ruleDeny () (TValue Bool)	
	(mk-val true false false) 
)
;##### Rule Obligations
(define-fun cns_obl_permit_ruleDeny ()  Bool
true
)
 
(define-fun cns_obl_deny_ruleDeny ()  Bool
true
)
 
;##### Rule Constraints
;PERMIT
(define-fun cns_ruleDeny_permit () Bool
 false 
)
;DENY
(define-fun cns_ruleDeny_deny () Bool
(and (isTrue cns_target_ruleDeny) cns_obl_deny_ruleDeny)
)
;NOT APP
(define-fun cns_ruleDeny_notApp () Bool
	(or (isFalse cns_target_ruleDeny) (miss cns_target_ruleDeny))
)
;INDET
(define-fun cns_ruleDeny_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_ruleDeny)
				(miss cns_target_ruleDeny)
			)
		)
		(and 
			(isTrue cns_target_ruleDeny)
			(not cns_obl_deny_ruleDeny)
		)
	)
)
;################### END CONSTRAINT RULE ruleDeny #########################
;################################ TOP-LEVEL POLICY AliceEDispensation CONSTRAINTs ###########################
;##### Policy Target
(define-fun cns_target_AliceEDispensation () (TValue Bool)
	(equalString const_Alice n_resource/patient-id)
)
;##### Policy Obligations
(define-fun cns_obl_permit_AliceEDispensation ()  Bool
	 (and true))
 
(define-fun cns_obl_deny_AliceEDispensation ()  Bool
	 (and (and
 		 (not (miss n_resource/patient-mail))
		 (not (err n_resource/patient-mail))
		 (not (miss const_Data_request_by_unauthorised_subject))
		 (not (err const_Data_request_by_unauthorised_subject))
)
))
 
;##### Policy Combining Algorithm
(define-fun cns_AliceEDispensation_cmb_final_permit () Bool
	 (or cns_eDis_permit cns_ruleDeny_permit)
)

(define-fun cns_AliceEDispensation_cmb_final_deny () Bool
	 (or 
		 (and cns_eDis_deny cns_ruleDeny_deny)
		 (and cns_eDis_deny cns_ruleDeny_notApp)
		 (and cns_eDis_notApp cns_ruleDeny_deny)
	 )
)

(define-fun cns_AliceEDispensation_cmb_final_notApp () Bool
	 (and cns_eDis_notApp cns_ruleDeny_notApp)
)

(define-fun cns_AliceEDispensation_cmb_final_indet () Bool
	 (or 
		 (and cns_eDis_indet (not cns_ruleDeny_permit))
		 (and (not cns_eDis_permit) cns_ruleDeny_indet)
	 )
)

 
;##### Policy Final Constraints
;PERMIT
(define-fun cns_AliceEDispensation_permit () Bool
	(and 
		(isTrue cns_target_AliceEDispensation)
		cns_AliceEDispensation_cmb_final_permit
		cns_obl_permit_AliceEDispensation
	)
)
;DENY
(define-fun cns_AliceEDispensation_deny () Bool
	(and 
		(isTrue cns_target_AliceEDispensation)
		cns_AliceEDispensation_cmb_final_deny
		cns_obl_deny_AliceEDispensation
	)
)
;NOT APP
(define-fun cns_AliceEDispensation_notApp () Bool
	(or
		(or (isFalse cns_target_AliceEDispensation) (miss cns_target_AliceEDispensation))
		(and (isTrue cns_target_AliceEDispensation) cns_AliceEDispensation_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_AliceEDispensation_indet () Bool
	(or 
		(not
			(or  
				(isBool cns_target_AliceEDispensation)
				(miss cns_target_AliceEDispensation)
			)
		)
		(and (isTrue cns_target_AliceEDispensation) cns_AliceEDispensation_cmb_final_indet)
		(and 
			(isTrue cns_target_AliceEDispensation)
			cns_AliceEDispensation_cmb_final_permit
			(not cns_obl_permit_AliceEDispensation)
		)
		(and 
			(isTrue cns_target_AliceEDispensation)
			cns_AliceEDispensation_cmb_final_deny
			(not cns_obl_deny_AliceEDispensation)
		)
	)
)
;################### END TOP-LEVEL POLICY AliceEDispensation CONSTRAINTs #########################
