package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
@Entity
public class metas extends Model{
	@Id
	@GeneratedValue
	public int id;
	
	@Required
	@NotEmpty
	public String nome;
	
	@Required
	@Min(1)
	public int prioridade;
	
	public boolean completa = false;
	 
	//public semana semana;
	
	
	public metas(){}
	
	public metas(String nome,int prioridade){
		this.setNome(nome);
		this.setPrioridade(prioridade);
		

	}
	public static void save(metas Meta){
		Meta.save();
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public static void delete(int id) {
		find.ref(id).delete();
	}
	
	public static void complete(int id) {
		metas meta = find.byId(id);
		if (meta != null) {
			meta.completa = true;
			metas.save(meta);
		}
	}

	static Finder<Integer, metas> find = new Finder<Integer, metas>(Integer.class, metas.class);
//	public semana getSemana() {
//		return semana;
//	}
//
//	public void setSemana(semana semana) {
//		this.semana = semana;
//	}
//	
	
}
