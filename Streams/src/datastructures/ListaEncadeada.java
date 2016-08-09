package datastructures;

public class ListaEncadeada
{
	class ListaIterator implements Iterator {
		private No atual;
		private ListaEncadeada container;
		
		public ListaIterator(ListaEncadeada lista) {
			atual = null;
			container = lista;
		}
		
		public boolean hasNext() {
			return atual == null || atual.getProximo() != null;
		}
		public Integer next() {
			if (atual == null)
				atual = head;
			else
				atual = atual.getProximo();
			return atual.getValor();
		}
		
		public void append(int valor) {
			if (atual == null) {
				String msg = "Use next() before using an iterator.";
				throw new IllegalStateException(msg);
			}
			No no = new No();
			no.setValor(valor);
			No anterior = atual;
			No proximo = atual.getProximo();
			no.setProximo(proximo);
			no.setAnterior(anterior);
			anterior.setProximo(no);
			if (proximo == null){
				container.tail = no;
				
			}else {
				proximo.setAnterior(no);
				
			}
			
		}
	}
	
	private No head;
	private No tail;

	public void append(int valor) {
		No no = new No();
		no.setValor(valor);

		if(head == null){
			this.head = no;
		}else{
			no.setAnterior(tail);
			tail.setProximo(no);
		}
		tail = no;	
	}
	
	public Iterator iterator() {
		return new ListaIterator(this);
	}
	
	/**
	 * Main, que um dia morrera...
	 */
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		lista.append(1);
		lista.append(2);
		lista.append(3);
		Iterator i = lista.iterator();
		while (i.hasNext())
			System.out.println(i.next());
		i = lista.iterator();
		i.next();
		i.append(50);
		i = lista.iterator();
		while (i.hasNext())
			System.out.println(i.next());
	}
}
