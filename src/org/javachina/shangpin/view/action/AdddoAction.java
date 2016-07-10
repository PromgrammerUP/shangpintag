package org.javachina.shangpin.view.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.javachina.shangpin.dto.ShangpinDto;
import org.javachina.shangpin.service.ShangpinService;

public class AdddoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		//1.从request中取得随机数2.从session中取得随机数3，进行比对
		boolean isValide = this.isTokenValid(request);
		if(isValide){
			AdddoForm adform = (AdddoForm)form;
//			System.out.println(adform.getName());
			String spName = new String(adform.getName().getBytes("iso8859-1"), "UTF-8");
			ShangpinDto dto = new ShangpinDto();
			dto.setName(spName);
			dto.setPrice(adform.getPrice());
			dto.setInputDate(adform.getInputDate());
			dto.setLeixingId(adform.getLeixingId());
			ShangpinService service = new ShangpinService();
			boolean isSuccess = service.addShangpin(dto);
			request.setAttribute("isSuccess", isSuccess);
			//删除原有令牌，然后重新设置令牌
			this.resetToken(request);
		}else{
			request.setAttribute("msg", "请不要重复提交");
		}
		
		return mapping.findForward("success");
	}

}
