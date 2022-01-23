package TRDZ.tasks;

import java.util.Arrays;

public class Notebook {
	private final int cost;
	private final int memory;
	private String mark;

	{//def initialize
		mark="Unknown";
		}

	public Notebook(String mark, int memory, int cost) {
		this.cost = Math.min(Math.max(cost,500),2000);
		this.memory = Math.min(Math.max(memory,4),24);
		if (Arrays.asList(Initialization.marks).contains(mark)) this.mark = mark;
		}

	public boolean compare(Notebook over) { //Метод сравнения двух элементов
		if (cost==over.cost) {
			if  (memory==over.memory) {
				return (Arrays.asList(Initialization.marks).indexOf(mark))  >  (Arrays.asList(Initialization.marks).indexOf(over.mark));
				}
			else return (memory>over.memory);
			}
		else return (cost>over.cost);
		}

	@Override
	public String toString() {
		return String.format ("Ноутбук %7s %2d за %d",mark,memory,cost);
		}

	}
