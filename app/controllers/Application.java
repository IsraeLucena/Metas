package controllers;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {
	static Form<metas> formsMeta = Form.form(metas.class);
	static Form<semana> formsSemana = Form.form(semana.class);
	
	public static Result index() {
		return ok(index.render(semana.all()));
	}

	public static Result save() {
		Form<metas> form = formsMeta.bindFromRequest();
		Form<semana> formS = formsSemana.bindFromRequest();
		if (!form.hasErrors() && !formS.hasErrors()) {
			metas novaMeta = form.get();
			semana novaSemana = semana.getById(form.get().id);
			
			if (novaSemana == null) novaSemana = new semana(form.get().id);
			
			metas meta = new metas(novaMeta.nome, novaMeta.prioridade);
			novaSemana.add(meta);
			
			semana.save(novaSemana);
			
			return redirect(routes.Application.index());
		} else {
			return redirect(routes.Application.index());
		}

	}

	public static Result complete(int id) {
		metas.complete(id);
		
		return redirect(routes.Application.index());
	}

	public static Result delete(int id) {
		metas.delete(id);
		
		return redirect(routes.Application.index());
	}
}
