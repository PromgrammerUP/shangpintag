package org.javachina.shangpin.view.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.javachina.shangpin.dto.LeixingDto;
import org.javachina.shangpin.dto.ShangpinDto;
import org.javachina.shangpin.service.UpdateService;

public class UpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		int spId = Integer.parseInt(id);
		UpdateService service = new UpdateService();
		ShangpinDto dto = service.getById(spId);
		if(dto!=null){
			ArrayList<LeixingDto> list = service.getAllLeixing();
			request.setAttribute("dto", dto);
			request.setAttribute("allLx", list);
			this.saveToken(request);
			return mapping.findForward("success");
			
		}else{
			//多更新的数据已经被删除，更新失败
			request.setAttribute("msg", "多更新的数据已经被删除，更新失败");
			return mapping.findForward("fail");
		}
		
	}

}
