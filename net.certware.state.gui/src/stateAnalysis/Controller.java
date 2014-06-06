/**
 */
package stateAnalysis;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link stateAnalysis.Controller#getName <em>Name</em>}</li>
 *   <li>{@link stateAnalysis.Controller#getDescription <em>Description</em>}</li>
 *   <li>{@link stateAnalysis.Controller#getDelegates <em>Delegates</em>}</li>
 *   <li>{@link stateAnalysis.Controller#getStateConstraint <em>State Constraint</em>}</li>
 *   <li>{@link stateAnalysis.Controller#getHardwareCommand <em>Hardware Command</em>}</li>
 * </ul>
 * </p>
 *
 * @see stateAnalysis.StateAnalysisPackage#getController()
 * @model annotation="gmf.node label='name' label.pattern='Controller: {0}'"
 * @generated
 */
public interface Controller extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see stateAnalysis.StateAnalysisPackage#getController_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link stateAnalysis.Controller#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see stateAnalysis.StateAnalysisPackage#getController_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link stateAnalysis.Controller#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Delegates</b></em>' reference list.
   * The list contents are of type {@link stateAnalysis.Controller}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Delegates</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delegates</em>' reference list.
   * @see stateAnalysis.StateAnalysisPackage#getController_Delegates()
   * @model annotation="gmf.link label='delegates'"
   * @generated
   */
  EList<Controller> getDelegates();

  /**
   * Returns the value of the '<em><b>State Constraint</b></em>' containment reference list.
   * The list contents are of type {@link stateAnalysis.StateConstraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Constraint</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Constraint</em>' containment reference list.
   * @see stateAnalysis.StateAnalysisPackage#getController_StateConstraint()
   * @model containment="true"
   *        annotation="gmf.compartment collapsible='true' layout='list'"
   * @generated
   */
  EList<StateConstraint> getStateConstraint();

  /**
   * Returns the value of the '<em><b>Hardware Command</b></em>' containment reference list.
   * The list contents are of type {@link stateAnalysis.HardwareCommand}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hardware Command</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hardware Command</em>' containment reference list.
   * @see stateAnalysis.StateAnalysisPackage#getController_HardwareCommand()
   * @model containment="true"
   *        annotation="gmf.compartment collapsible='true' layout='list'"
   * @generated
   */
  EList<HardwareCommand> getHardwareCommand();

} // Controller