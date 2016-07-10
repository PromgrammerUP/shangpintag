package org.javachina.shangpin.view.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.javachina.shangpin.dto.LeixingDto;
import org.javachina.shangpin.service.LeixingService;

public class AddAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LeixingService service = new LeixingService();
		ArrayList<LeixingDto> list = service.getAllLeixing();
		request.setAttribute("list", list);
		//令牌作用是防止重复提交，在进入提交的form之前设置一个令牌，然后在提交form后的action中进行比对。
		//加入令牌：生成一个随机数 1.加入到request中 （为了使页面标签生成一个随机数，注意页面中用标签产生的form会自动加入一个隐藏域，其中包括了该随机数；如果直接使用form需要自己取得随机数然后设置到隐藏域中）
		//2.将随机数放入到session中（为了跟页面中的随机数比对）
		this.saveToken(request);
		return mapping.findForward("success");
	}
	
}
 