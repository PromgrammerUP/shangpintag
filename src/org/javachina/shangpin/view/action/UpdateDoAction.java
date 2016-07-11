package org.javachina.shangpin.view.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.javachina.shangpin.dto.ShangpinDto;
import org.javachina.shangpin.service.UpdateDoService;

public class UpdateDoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean isValid = this.isTokenValid(request);
		if(isValid){
			
			UpdateDoForm upForm = (UpdateDoForm)form;
			String name = new String(upForm.getName().getBytes("iso8859-1"), "utf-8");
			ShangpinDto sp = new ShangpinDto(upForm.getId(), name, upForm.getPrice(), upForm.getIntputDate(), upForm.getLeixingId());
			UpdateDoService service = new UpdateDoService();
			boolean isSuccess = service.updateSp(sp);
			String msg = null;
			if(isSuccess){
				msg = "更新成功";
			}else{
				msg="更新失败";
			}
			request.setAttribute("msg", msg);
		}else{
			request.setAttribute("msg", "请勿重复提交");
		}
		return mapping.findForward("success");

	}

}
