package org.javachina.shangpin.view.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.javachina.shangpin.dto.ShangpinDto;
import org.javachina.shangpin.service.ShangpinService;

public class ListAllAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ShangpinService service = new ShangpinService();
		ArrayList<ShangpinDto> list = service.listAll();
		request.setAttribute("list", list);
		
		return mapping.findForward("success");
	}

}
