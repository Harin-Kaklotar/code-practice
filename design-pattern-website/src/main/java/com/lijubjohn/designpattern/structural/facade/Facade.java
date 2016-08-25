package com.lijubjohn.designpattern.structural.facade;

/**
 * Created by liju on 8/24/16.
 */
public class Facade {
}

// Complex components (in this example components of Computer)
interface RAM {
    void load(byte[] data);
}

interface HDD {
    byte[] read(long startPosition);
}

interface CPU {
    long lookupBIOSInstruction();
    void initialize();
    void executeInstruction();
}

// Interface left un-implemented intentionally to avoid code clutter .

// Facade exposes a simple interface for client abstracting all complex interfaces internally
class ComputerFacade {
    private RAM ram;
    private HDD hdd;
    private CPU cpu;

    public ComputerFacade(RAM ram, HDD hdd, CPU cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // simple interface , for booting system
    public void boot() {
        cpu.initialize();
        byte[] bootInstruction = hdd.read(cpu.lookupBIOSInstruction());
        ram.load(bootInstruction);
        cpu.executeInstruction();
    }
}

class Client {
    public static void main(String[] args) {
        RAM ram = null;
        CPU cpu = null;
        HDD hdd = null;// use concrete implementation
        ComputerFacade computerFacade = new ComputerFacade(ram, hdd, cpu);
        computerFacade.boot();
    }
}