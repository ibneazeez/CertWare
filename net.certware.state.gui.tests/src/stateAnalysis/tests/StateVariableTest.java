/**
 */
package stateAnalysis.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import stateAnalysis.StateAnalysisFactory;
import stateAnalysis.StateVariable;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>State Variable</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateVariableTest extends TestCase
{

  /**
   * The fixture for this State Variable test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateVariable fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(StateVariableTest.class);
  }

  /**
   * Constructs a new State Variable test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateVariableTest(String name)
  {
    super(name);
  }

  /**
   * Sets the fixture for this State Variable test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(StateVariable fixture)
  {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this State Variable test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateVariable getFixture()
  {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception
  {
    setFixture(StateAnalysisFactory.eINSTANCE.createStateVariable());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception
  {
    setFixture(null);
  }

} //StateVariableTest