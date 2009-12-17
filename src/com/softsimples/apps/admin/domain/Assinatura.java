package com.softsimples.apps.admin.domain;

import com.mongodb.BasicDBObject;
import com.softsimples.domain.Domain;

public abstract class Assinatura extends Domain {

	public Assinatura() {
		this.vo = new BasicDBObject();
		this.vo.put("usuario", "");
		this.vo.put("acessos", 0);
		this.vo.put("ativa", false);
		this.vo.put("aplicacao", "");
		this.vo.put("tipoConta", TipoAssinatura.Gratis.ordinal());
	}
	
	public Assinatura(BasicDBObject vo) {
		super(vo);
	}
}
