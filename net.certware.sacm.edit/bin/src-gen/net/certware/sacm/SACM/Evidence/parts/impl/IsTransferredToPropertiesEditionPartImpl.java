// Copyright (c) 2013 United States Government as represented by the National Aeronautics and Space Administration.  All rights reserved.
package net.certware.sacm.SACM.Evidence.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import net.certware.sacm.SACM.Evidence.parts.EvidenceViewsRepository;
import net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart;

import net.certware.sacm.SACM.Evidence.providers.EvidenceMessages;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author Kestrel Technology LLC
 * 
 */
public class IsTransferredToPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, IsTransferredToPropertiesEditionPart {

	protected Text id;
	protected ReferencesTable timing;
	protected List<ViewerFilter> timingBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> timingFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable custody;
	protected List<ViewerFilter> custodyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> custodyFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable provenance;
	protected List<ViewerFilter> provenanceBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> provenanceFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable event;
	protected List<ViewerFilter> eventBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eventFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public IsTransferredToPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence isTransferredToStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = isTransferredToStep.addStep(EvidenceViewsRepository.IsTransferredTo.Properties.class);
		propertiesStep.addStep(EvidenceViewsRepository.IsTransferredTo.Properties.id);
		propertiesStep.addStep(EvidenceViewsRepository.IsTransferredTo.Properties.timing);
		propertiesStep.addStep(EvidenceViewsRepository.IsTransferredTo.Properties.custody);
		propertiesStep.addStep(EvidenceViewsRepository.IsTransferredTo.Properties.provenance);
		propertiesStep.addStep(EvidenceViewsRepository.IsTransferredTo.Properties.event);
		
		
		composer = new PartComposer(isTransferredToStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EvidenceViewsRepository.IsTransferredTo.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EvidenceViewsRepository.IsTransferredTo.Properties.id) {
					return createIdText(parent);
				}
				if (key == EvidenceViewsRepository.IsTransferredTo.Properties.timing) {
					return createTimingAdvancedTableComposition(parent);
				}
				if (key == EvidenceViewsRepository.IsTransferredTo.Properties.custody) {
					return createCustodyAdvancedTableComposition(parent);
				}
				if (key == EvidenceViewsRepository.IsTransferredTo.Properties.provenance) {
					return createProvenanceAdvancedTableComposition(parent);
				}
				if (key == EvidenceViewsRepository.IsTransferredTo.Properties.event) {
					return createEventAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EvidenceMessages.IsTransferredToPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createIdText(Composite parent) {
		createDescription(parent, EvidenceViewsRepository.IsTransferredTo.Properties.id, EvidenceMessages.IsTransferredToPropertiesEditionPart_IdLabel);
		id = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData idData = new GridData(GridData.FILL_HORIZONTAL);
		id.setLayoutData(idData);
		id.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
			}

		});
		id.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, EvidenceViewsRepository.IsTransferredTo.Properties.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EvidenceViewsRepository.IsTransferredTo.Properties.id, EvidenceViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTimingAdvancedTableComposition(Composite parent) {
		this.timing = new ReferencesTable(getDescription(EvidenceViewsRepository.IsTransferredTo.Properties.timing, EvidenceMessages.IsTransferredToPropertiesEditionPart_TimingLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.timing, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				timing.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.timing, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				timing.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.timing, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				timing.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.timing, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				timing.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.timingFilters) {
			this.timing.addFilter(filter);
		}
		this.timing.setHelpText(propertiesEditionComponent.getHelpContent(EvidenceViewsRepository.IsTransferredTo.Properties.timing, EvidenceViewsRepository.SWT_KIND));
		this.timing.createControls(parent);
		this.timing.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.timing, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData timingData = new GridData(GridData.FILL_HORIZONTAL);
		timingData.horizontalSpan = 3;
		this.timing.setLayoutData(timingData);
		this.timing.setLowerBound(0);
		this.timing.setUpperBound(-1);
		timing.setID(EvidenceViewsRepository.IsTransferredTo.Properties.timing);
		timing.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTimingAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createCustodyAdvancedTableComposition(Composite parent) {
		this.custody = new ReferencesTable(getDescription(EvidenceViewsRepository.IsTransferredTo.Properties.custody, EvidenceMessages.IsTransferredToPropertiesEditionPart_CustodyLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.custody, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				custody.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.custody, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				custody.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.custody, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				custody.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.custody, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				custody.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.custodyFilters) {
			this.custody.addFilter(filter);
		}
		this.custody.setHelpText(propertiesEditionComponent.getHelpContent(EvidenceViewsRepository.IsTransferredTo.Properties.custody, EvidenceViewsRepository.SWT_KIND));
		this.custody.createControls(parent);
		this.custody.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.custody, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData custodyData = new GridData(GridData.FILL_HORIZONTAL);
		custodyData.horizontalSpan = 3;
		this.custody.setLayoutData(custodyData);
		this.custody.setLowerBound(0);
		this.custody.setUpperBound(-1);
		custody.setID(EvidenceViewsRepository.IsTransferredTo.Properties.custody);
		custody.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createCustodyAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createProvenanceAdvancedTableComposition(Composite parent) {
		this.provenance = new ReferencesTable(getDescription(EvidenceViewsRepository.IsTransferredTo.Properties.provenance, EvidenceMessages.IsTransferredToPropertiesEditionPart_ProvenanceLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.provenance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				provenance.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.provenance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				provenance.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.provenance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				provenance.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.provenance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				provenance.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.provenanceFilters) {
			this.provenance.addFilter(filter);
		}
		this.provenance.setHelpText(propertiesEditionComponent.getHelpContent(EvidenceViewsRepository.IsTransferredTo.Properties.provenance, EvidenceViewsRepository.SWT_KIND));
		this.provenance.createControls(parent);
		this.provenance.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.provenance, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData provenanceData = new GridData(GridData.FILL_HORIZONTAL);
		provenanceData.horizontalSpan = 3;
		this.provenance.setLayoutData(provenanceData);
		this.provenance.setLowerBound(0);
		this.provenance.setUpperBound(-1);
		provenance.setID(EvidenceViewsRepository.IsTransferredTo.Properties.provenance);
		provenance.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createProvenanceAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEventAdvancedTableComposition(Composite parent) {
		this.event = new ReferencesTable(getDescription(EvidenceViewsRepository.IsTransferredTo.Properties.event, EvidenceMessages.IsTransferredToPropertiesEditionPart_EventLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.event, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				event.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.event, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				event.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.event, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				event.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.event, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				event.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eventFilters) {
			this.event.addFilter(filter);
		}
		this.event.setHelpText(propertiesEditionComponent.getHelpContent(EvidenceViewsRepository.IsTransferredTo.Properties.event, EvidenceViewsRepository.SWT_KIND));
		this.event.createControls(parent);
		this.event.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(IsTransferredToPropertiesEditionPartImpl.this, EvidenceViewsRepository.IsTransferredTo.Properties.event, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eventData = new GridData(GridData.FILL_HORIZONTAL);
		eventData.horizontalSpan = 3;
		this.event.setLayoutData(eventData);
		this.event.setLowerBound(0);
		this.event.setUpperBound(-1);
		event.setID(EvidenceViewsRepository.IsTransferredTo.Properties.event);
		event.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createEventAdvancedTableComposition

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#getId()
	 * 
	 */
	public String getId() {
		return id.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#setId(String newValue)
	 * 
	 */
	public void setId(String newValue) {
		if (newValue != null) {
			id.setText(newValue);
		} else {
			id.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EvidenceViewsRepository.IsTransferredTo.Properties.id);
		if (eefElementEditorReadOnlyState && id.isEnabled()) {
			id.setEnabled(false);
			id.setToolTipText(EvidenceMessages.IsTransferredTo_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
			id.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#initTiming(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTiming(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		timing.setContentProvider(contentProvider);
		timing.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EvidenceViewsRepository.IsTransferredTo.Properties.timing);
		if (eefElementEditorReadOnlyState && timing.isEnabled()) {
			timing.setEnabled(false);
			timing.setToolTipText(EvidenceMessages.IsTransferredTo_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !timing.isEnabled()) {
			timing.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#updateTiming()
	 * 
	 */
	public void updateTiming() {
	timing.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addFilterTiming(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTiming(ViewerFilter filter) {
		timingFilters.add(filter);
		if (this.timing != null) {
			this.timing.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addBusinessFilterTiming(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTiming(ViewerFilter filter) {
		timingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#isContainedInTimingTable(EObject element)
	 * 
	 */
	public boolean isContainedInTimingTable(EObject element) {
		return ((ReferencesTableSettings)timing.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#initCustody(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initCustody(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		custody.setContentProvider(contentProvider);
		custody.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EvidenceViewsRepository.IsTransferredTo.Properties.custody);
		if (eefElementEditorReadOnlyState && custody.isEnabled()) {
			custody.setEnabled(false);
			custody.setToolTipText(EvidenceMessages.IsTransferredTo_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !custody.isEnabled()) {
			custody.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#updateCustody()
	 * 
	 */
	public void updateCustody() {
	custody.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addFilterCustody(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCustody(ViewerFilter filter) {
		custodyFilters.add(filter);
		if (this.custody != null) {
			this.custody.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addBusinessFilterCustody(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCustody(ViewerFilter filter) {
		custodyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#isContainedInCustodyTable(EObject element)
	 * 
	 */
	public boolean isContainedInCustodyTable(EObject element) {
		return ((ReferencesTableSettings)custody.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#initProvenance(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initProvenance(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		provenance.setContentProvider(contentProvider);
		provenance.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EvidenceViewsRepository.IsTransferredTo.Properties.provenance);
		if (eefElementEditorReadOnlyState && provenance.isEnabled()) {
			provenance.setEnabled(false);
			provenance.setToolTipText(EvidenceMessages.IsTransferredTo_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !provenance.isEnabled()) {
			provenance.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#updateProvenance()
	 * 
	 */
	public void updateProvenance() {
	provenance.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addFilterProvenance(ViewerFilter filter)
	 * 
	 */
	public void addFilterToProvenance(ViewerFilter filter) {
		provenanceFilters.add(filter);
		if (this.provenance != null) {
			this.provenance.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addBusinessFilterProvenance(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToProvenance(ViewerFilter filter) {
		provenanceBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#isContainedInProvenanceTable(EObject element)
	 * 
	 */
	public boolean isContainedInProvenanceTable(EObject element) {
		return ((ReferencesTableSettings)provenance.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#initEvent(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEvent(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		event.setContentProvider(contentProvider);
		event.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EvidenceViewsRepository.IsTransferredTo.Properties.event);
		if (eefElementEditorReadOnlyState && event.isEnabled()) {
			event.setEnabled(false);
			event.setToolTipText(EvidenceMessages.IsTransferredTo_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !event.isEnabled()) {
			event.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#updateEvent()
	 * 
	 */
	public void updateEvent() {
	event.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addFilterEvent(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEvent(ViewerFilter filter) {
		eventFilters.add(filter);
		if (this.event != null) {
			this.event.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#addBusinessFilterEvent(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEvent(ViewerFilter filter) {
		eventBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see net.certware.sacm.SACM.Evidence.parts.IsTransferredToPropertiesEditionPart#isContainedInEventTable(EObject element)
	 * 
	 */
	public boolean isContainedInEventTable(EObject element) {
		return ((ReferencesTableSettings)event.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EvidenceMessages.IsTransferredTo_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}