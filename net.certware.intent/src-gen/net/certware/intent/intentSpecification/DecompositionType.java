/**
 */
package net.certware.intent.intentSpecification;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decomposition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link net.certware.intent.intentSpecification.DecompositionType#getTypeName <em>Type Name</em>}</li>
 * </ul>
 *
 * @see net.certware.intent.intentSpecification.IntentSpecificationPackage#getDecompositionType()
 * @model
 * @generated
 */
public interface DecompositionType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see net.certware.intent.intentSpecification.IntentSpecificationPackage#getDecompositionType_TypeName()
   * @model
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link net.certware.intent.intentSpecification.DecompositionType#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

} // DecompositionType
