/**
 * generated by Xtext
 */
package it.unifi.xtext.facpl.ui.outline;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration;
import it.unifi.xtext.facpl.facpl2.Import;
import it.unifi.xtext.facpl.facpl2.MainFacpl;
import it.unifi.xtext.facpl.facpl2.PAF;
import it.unifi.xtext.facpl.facpl2.PDP;
import it.unifi.xtext.facpl.facpl2.PEPAlg;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.facpl2.Rule;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
@SuppressWarnings("all")
public class Facpl2OutlineTreeProvider extends DefaultOutlineTreeProvider {
  @Inject
  private IImageHelper imageHelper;
  
  public Image _image(final FacplPolicy e) {
    return this.imageHelper.getImage("policies.gif");
  }
  
  public Image _image(final PEPAlg s) {
    return this.imageHelper.getImage("policies.gif");
  }
  
  public Image _image(final Rule e) {
    return this.imageHelper.getImage("rule.gif");
  }
  
  public Image _image(final MainFacpl e) {
    return this.imageHelper.getImage("main.gif");
  }
  
  public Image _image(final FunctionDeclaration e) {
    return this.imageHelper.getImage("main.gif");
  }
  
  public Image _image(final Import e) {
    return this.imageHelper.getImage("Import.gif");
  }
  
  public Image _image(final Request e) {
    return this.imageHelper.getImage("Property.gif");
  }
  
  public void _createChildren(final DocumentRootNode parentNode, final Facpl facpl) {
    EList<Import> _importEl = facpl.getImportEl();
    boolean _notEquals = (!Objects.equal(_importEl, null));
    if (_notEquals) {
      EList<Import> _importEl_1 = facpl.getImportEl();
      for (final Import i : _importEl_1) {
        Image __image = this._image(i);
        String _importURI = i.getImportURI();
        String _plus = ("imp : " + _importURI);
        this.createEStructuralFeatureNode(parentNode, i, Facpl2Package.Literals.IMPORT__IMPORT_URI, __image, _plus, true);
      }
    }
    EList<Request> _requests = facpl.getRequests();
    boolean _notEquals_1 = (!Objects.equal(_requests, null));
    if (_notEquals_1) {
      EList<Request> _requests_1 = facpl.getRequests();
      for (final Request r : _requests_1) {
        Image __image_1 = this._image(r);
        String _name = r.getName();
        String _plus_1 = ("req : " + _name);
        this.createEStructuralFeatureNode(parentNode, r, Facpl2Package.Literals.REQUEST__NAME, __image_1, _plus_1, true);
      }
    }
    EList<FunctionDeclaration> _declarations = facpl.getDeclarations();
    boolean _notEquals_2 = (!Objects.equal(_declarations, null));
    if (_notEquals_2) {
      EList<FunctionDeclaration> _declarations_1 = facpl.getDeclarations();
      for (final FunctionDeclaration f : _declarations_1) {
        Image __image_2 = this._image(f);
        String _name_1 = f.getName();
        String _plus_2 = ("fun :" + _name_1);
        this.createEStructuralFeatureNode(parentNode, f, Facpl2Package.Literals.FUNCTION__FUNCTION_ID, __image_2, _plus_2, true);
      }
    }
    MainFacpl _main = facpl.getMain();
    boolean _notEquals_3 = (!Objects.equal(_main, null));
    if (_notEquals_3) {
      MainFacpl _main_1 = facpl.getMain();
      MainFacpl _main_2 = facpl.getMain();
      Image __image_3 = this._image(_main_2);
      EStructuralFeatureNode main = this.createEStructuralFeatureNode(parentNode, _main_1, 
        Facpl2Package.Literals.MAIN_FACPL__EXT_INDET, __image_3, "main ", true);
      MainFacpl _main_3 = facpl.getMain();
      PAF _paf = _main_3.getPaf();
      boolean _notEquals_4 = (!Objects.equal(_paf, null));
      if (_notEquals_4) {
        MainFacpl _main_4 = facpl.getMain();
        PAF _paf_1 = _main_4.getPaf();
        PDP _pdp = _paf_1.getPdp();
        boolean _notEquals_5 = (!Objects.equal(_pdp, null));
        if (_notEquals_5) {
          MainFacpl _main_5 = facpl.getMain();
          PAF _paf_2 = _main_5.getPaf();
          PDP _pdp_1 = _paf_2.getPdp();
          EList<AbstractPolicyIncl> _polSet = _pdp_1.getPolSet();
          for (final AbstractPolicyIncl pol : _polSet) {
            {
              FacplPolicy _newPolicy = pol.getNewPolicy();
              boolean _notEquals_6 = (!Objects.equal(_newPolicy, null));
              if (_notEquals_6) {
                FacplPolicy _newPolicy_1 = pol.getNewPolicy();
                if ((_newPolicy_1 instanceof PolicySet)) {
                  FacplPolicy _newPolicy_2 = pol.getNewPolicy();
                  this.createPolicySet(main, ((PolicySet) _newPolicy_2));
                }
                FacplPolicy _newPolicy_3 = pol.getNewPolicy();
                if ((_newPolicy_3 instanceof Rule)) {
                  FacplPolicy _newPolicy_4 = pol.getNewPolicy();
                  this.createPolicySet(main, ((Rule) _newPolicy_4));
                }
              }
              PolicySet _refPol = pol.getRefPol();
              boolean _notEquals_7 = (!Objects.equal(_refPol, null));
              if (_notEquals_7) {
                PolicySet _refPol_1 = pol.getRefPol();
                PolicySet _refPol_2 = pol.getRefPol();
                Image __image_4 = this._image(_refPol_2);
                PolicySet _refPol_3 = pol.getRefPol();
                String _name_2 = _refPol_3.getName();
                String _plus_3 = ("ref-pol : " + _name_2);
                this.createEStructuralFeatureNode(main, _refPol_1, 
                  Facpl2Package.Literals.FACPL_POLICY__NAME, __image_4, _plus_3, false);
              }
            }
          }
        }
      }
    }
    EList<PolicySet> _policies = facpl.getPolicies();
    boolean _notEquals_6 = (!Objects.equal(_policies, null));
    if (_notEquals_6) {
      EList<PolicySet> _policies_1 = facpl.getPolicies();
      for (final FacplPolicy pol_1 : _policies_1) {
        {
          if ((pol_1 instanceof PolicySet)) {
            this.createPolicySet(parentNode, ((PolicySet) pol_1));
          }
          if ((pol_1 instanceof Rule)) {
            this.createPolicySet(parentNode, ((Rule) pol_1));
          }
        }
      }
    }
  }
  
  public EStructuralFeatureNode createPolicySet(final IOutlineNode parentNode, final PolicySet pol) {
    EStructuralFeatureNode _xblockexpression = null;
    {
      Image __image = this._image(pol);
      String _name = pol.getName();
      String _plus = ("pSet : " + _name);
      EStructuralFeatureNode polSetNode = this.createEStructuralFeatureNode(parentNode, pol, 
        Facpl2Package.Literals.FACPL_POLICY__NAME, __image, _plus, false);
      this.createEStructuralFeatureNode(polSetNode, pol, Facpl2Package.Literals.FACPL_POLICY__TARGET, null, "target", 
        true);
      EList<AbstractPolicyIncl> _policies = pol.getPolicies();
      for (final AbstractPolicyIncl el : _policies) {
        {
          FacplPolicy _newPolicy = el.getNewPolicy();
          boolean _notEquals = (!Objects.equal(_newPolicy, null));
          if (_notEquals) {
            FacplPolicy _newPolicy_1 = el.getNewPolicy();
            if ((_newPolicy_1 instanceof PolicySet)) {
              FacplPolicy _newPolicy_2 = el.getNewPolicy();
              this.createPolicySet(polSetNode, ((PolicySet) _newPolicy_2));
            }
            FacplPolicy _newPolicy_3 = el.getNewPolicy();
            if ((_newPolicy_3 instanceof Rule)) {
              FacplPolicy _newPolicy_4 = el.getNewPolicy();
              this.createPolicySet(polSetNode, ((Rule) _newPolicy_4));
            }
          }
          PolicySet _refPol = el.getRefPol();
          boolean _notEquals_1 = (!Objects.equal(_refPol, null));
          if (_notEquals_1) {
            PolicySet _refPol_1 = el.getRefPol();
            PolicySet _refPol_2 = el.getRefPol();
            Image __image_1 = this._image(_refPol_2);
            PolicySet _refPol_3 = el.getRefPol();
            String _name_1 = _refPol_3.getName();
            String _plus_1 = ("ref-pol : " + _name_1);
            this.createEStructuralFeatureNode(parentNode, _refPol_1, Facpl2Package.Literals.FACPL_POLICY__NAME, __image_1, _plus_1, false);
          }
        }
      }
      _xblockexpression = this.createEStructuralFeatureNode(polSetNode, pol, Facpl2Package.Literals.FACPL__POLICIES, null, "obligation", 
        true);
    }
    return _xblockexpression;
  }
  
  public void createPolicySet(final IOutlineNode parentNode, final Rule pol) {
    Image __image = this._image(pol);
    String _name = pol.getName();
    String _plus = ("rul : " + _name);
    EStructuralFeatureNode polNode = this.createEStructuralFeatureNode(parentNode, pol, 
      Facpl2Package.Literals.FACPL_POLICY__NAME, __image, _plus, false);
  }
  
  public boolean _isLeaf(final Request request) {
    return true;
  }
  
  public boolean _isLeaf(final Rule request) {
    return true;
  }
  
  public boolean _isLeaf(final PolicySet request) {
    return true;
  }
  
  public boolean _isLeaf(final FacplPolicy request) {
    return true;
  }
}
