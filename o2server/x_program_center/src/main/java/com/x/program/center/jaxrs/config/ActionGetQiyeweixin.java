package com.x.program.center.jaxrs.config;

import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.config.Config;
import com.x.base.core.project.config.Qiyeweixin;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;

class ActionGetQiyeweixin extends BaseAction {

	ActionResult<Wo> execute(EffectivePerson effectivePerson) throws Exception {
		ActionResult<Wo> result = new ActionResult<>();
		Wo wo = Wo.copier.copy(Config.qiyeweixin());
		result.setData(wo);
		return result;
	}

	public static class Wo extends Qiyeweixin {

		static WrapCopier<Qiyeweixin, Wo> copier = WrapCopierFactory.wo(Qiyeweixin.class, Wo.class, null, null);

	}
}