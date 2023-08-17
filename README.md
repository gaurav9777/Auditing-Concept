# Auditing-Concept
Spring Data provides sophisticated support to transparently keep track of who created or changed an entity and the point in time this happened. To benefit from that functionality you have to equip your entity classes with auditing metadata that can be defined either using annotations or by implementing an interface.

* @CreatedDate
*	@LastModifiedDate
*	@CreatedBy
*	@LastModifiedBy

## in main class
* @EnableJpaAuditing

## in entity class
* @EntityListeners(AuditingEntityListener.class)
