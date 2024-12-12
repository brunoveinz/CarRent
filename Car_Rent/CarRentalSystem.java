/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 *
 * @author maran
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CarRentalSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Initialize DataStore
                DataStore.initialize();
                new MainInterface();
            } catch (Exception e) {
                e.printStackTrace(); // Log any exception that occurs during UI loading
            }
        });
    }
}

class DataStore {
    public static final java.util.List<Cliente> CLIENTES = new java.util.ArrayList<>();
    private static final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(CLIENTES);
    public static final ArrayList<Vehiculo> VEHICULOS = new ArrayList<>();
    public static final Map<Integer, ArriendoCuota> ARRIENDOS = new HashMap<>();

    public static void addClientChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public static void notifyClientChangeListeners() {
        pcs.firePropertyChange("clientes", null, CLIENTES);
    }

    public static void initialize() {
        // Initialize with static data
        CLIENTES.add(new Cliente("12345678-9", "Juan Perez", true));
        CLIENTES.add(new Cliente("98765432-1", "Maria Gonzalez", true));

        VEHICULOS.add(new Vehiculo("ABC-123", 'A'));
        VEHICULOS.add(new Vehiculo("XYZ-789", 'B'));
    }
}

class MainInterface {

    public MainInterface() {
        JFrame frame = new JFrame("Sistema de Arriendo de Vehículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem rentOption = new JMenuItem("Arrendar con Cuotas");
        JMenuItem payOption = new JMenuItem("Pagar Cuota");

        rentOption.addActionListener(e -> new RentInterface());
        payOption.addActionListener(e -> new PaymentInterface());

        menu.add(rentOption);
        menu.add(payOption);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);

        JLabel title = new JLabel("Sistema de Arriendo de Vehículos", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        ImageIcon icon = new ImageIcon("Venta-de-autos.jpg");
        Image image = icon.getImage(); // transforma de imageIcon a image
        Image newimg = image.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH); // escalar la imagen
        icon = new ImageIcon(newimg); //Transforma devuelta a ImageIcon
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(title, BorderLayout.NORTH);
        frame.add(imageLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

class RentInterface {

    public RentInterface() {
        JFrame frame = new JFrame("Arrendar con Cuotas");
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(2,1,10,10));

        JComboBox<String> clientDropdown = new JComboBox<>();
        JComboBox<String> carDropdown = new JComboBox<>();
        JButton addClientButton = new JButton("Ingresar nuevo Cliente");

        JTextField rentDateField = new JTextField();
        JTextField daysField = new JTextField();
        JTextField pricePerDayField = new JTextField();
        JTextField totalAmountField = new JTextField();
        totalAmountField.setEditable(false);
        JTextField installmentsField = new JTextField();

        JButton saveButton = new JButton("Guardar arriendo y mostrar cuotas >>");
        
        JPanel form1 = new JPanel(new GridBagLayout());
        JPanel form2 = new JPanel(new GridBagLayout());

        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;

        cons.gridx = 0;
        cons.gridy = 0;
        form1.add(new JLabel("Seleccione CLIENTE:"), cons);
        
        cons.weightx=2;
        cons.gridx = 1;
        cons.gridy = 0;
        form1.add(clientDropdown, cons);

        cons.weightx=0;
        cons.gridx = 2;
        cons.gridy = 0;
        form1.add(new JLabel("Seleccione AUTOMOVIL:"), cons);

        cons.weightx=2;
        cons.gridx = 3;
        cons.gridy = 0;
        form1.add(carDropdown, cons);
        
        cons.weightx=0;
        cons.gridx = 0;
        cons.gridy = 1;
        form1.add(addClientButton, cons);

        cons.weightx=0;
        cons.gridx = 0;
        cons.gridy = 0;
        form2.add(new JLabel("Fecha Arriendo:"), cons);

        cons.weightx=2;
        cons.gridx = 1;
        cons.gridy = 0;
        form2.add(rentDateField, cons);

        cons.weightx=0;
        cons.gridx = 0;
        cons.gridy = 1;
        form2.add(new JLabel("Días:"), cons);

        cons.weightx=2;
        cons.gridx = 1;
        cons.gridy = 1;
        form2.add(daysField, cons);

        cons.weightx=0;
        cons.gridx = 2;
        cons.gridy = 0;
        form2.add(new JLabel("Precio por día:"), cons);

        cons.weightx=2;
        cons.gridx = 3;
        cons.gridy = 0;
        form2.add(pricePerDayField, cons);

        cons.weightx=0;
        cons.gridx = 2;
        cons.gridy = 1;
        form2.add(new JLabel("Cantidad de cuotas:"), cons);

        cons.weightx=2;
        cons.gridx = 3;
        cons.gridy = 1;
        form2.add(installmentsField, cons);

        cons.weightx=0;
        cons.gridx = 0;
        cons.gridy = 2;
        form2.add(new JLabel("MONTO A PAGAR:"), cons);

        cons.weightx=2;
        cons.gridx = 1;
        cons.gridy = 2;
        form2.add(totalAmountField, cons);

        cons.gridwidth=4;
        cons.weightx=0;
        cons.gridx = 0;
        cons.gridy = 3;
        form2.add(saveButton, cons);

        formPanel.add(form1);
        formPanel.add(form2);

        JPanel clientPanel = new JPanel(new GridLayout(2,1,10 ,10));
        JLabel title = new JLabel("ARRIENDOS CON CUOTAS", JLabel.CENTER);
        clientPanel.add(title);
        

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("CUOTAS A PAGAR"));

        JTextArea installmentArea = new JTextArea();
        installmentArea.setEditable(false);
        rightPanel.add(new JScrollPane(installmentArea), BorderLayout.CENTER);
        JButton payFirstInstallmentButton = new JButton("Pagar Primera Cuota");
        rightPanel.add(payFirstInstallmentButton, BorderLayout.SOUTH);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(clientPanel, BorderLayout.NORTH);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        
        // Populate clientDropdown with client names
            for (Cliente cliente : DataStore.CLIENTES) {
                clientDropdown.addItem(cliente.getNombre());
            }
        
        // Add a listener to monitor changes to DataStore.CLIENTES
        DataStore.addClientChangeListener(evt -> {
            clientDropdown.removeAllItems();
            for (Cliente cliente : DataStore.CLIENTES) {
                clientDropdown.addItem(cliente.getNombre());
            }
        });
        
        // Populate carDropdown with vehicle license plates
        for (Vehiculo vehiculo : DataStore.VEHICULOS) {
            carDropdown.addItem(vehiculo.getPatente());
        }

        frame.add(mainPanel);
        frame.setVisible(true);

        // Add listeners here
        addClientButton.addActionListener(e -> new ClientInterface());
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Fetch selected client
                    Cliente selectedClient = DataStore.CLIENTES.stream()
                            .filter(cliente -> cliente.getNombre().equals(clientDropdown.getSelectedItem()))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
                    
                    // Fetch selected vehicle
                    Vehiculo selectedVehicle = DataStore.VEHICULOS.stream()
                            .filter(vehiculo -> vehiculo.getPatente().equals(carDropdown.getSelectedItem()))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));
                    
                    // Fetch other inputs
                    String rentDate = rentDateField.getText();
                    int days = Integer.parseInt(daysField.getText());
                    int pricePerDay = Integer.parseInt(pricePerDayField.getText());
                    int numInstallments = Integer.parseInt(installmentsField.getText());
                    
                    // Create Arriendo and ArriendoCuota
                    int numArriendo = DataStore.ARRIENDOS.size() + 1;
                    ArriendoCuota arriendo = new ArriendoCuota(numArriendo, rentDate, days, selectedClient, selectedVehicle, numInstallments);
                    arriendo.ingresarArriendoConCuota(pricePerDay);
                    
                    // Update vehicle status
                    selectedVehicle.setCondicion('R'); // Mark as rented
                    
                    // Save to datastore
                    DataStore.ARRIENDOS.put(numArriendo, arriendo);
                    
                    // Display cuotas
                    StringBuilder cuotasDetails = new StringBuilder("Detalles de cuotas:\n");
                    for (CuotaArriendo cuota : arriendo.getCuotas()) {
                        cuotasDetails.append("Cuota ").append(cuota.getNumCuota()).append(": ").append(cuota.getValorCuota()).append("\n");
                    }
                    installmentArea.setText(cuotasDetails.toString());
                    
                    JOptionPane.showMessageDialog(frame, "Arriendo registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                    int days = Integer.parseInt(daysField.getText());
                    int pricePerDay = Integer.parseInt(pricePerDayField.getText());
                    int totalAmount = days * pricePerDay;
                    totalAmountField.setText(String.valueOf(totalAmount));
                
            }
            });
            payFirstInstallmentButton.addActionListener(e -> {
                try {
                    String selectedClientName = (String) clientDropdown.getSelectedItem();
        
                    if (selectedClientName == null) {
                        throw new IllegalArgumentException("Seleccione un cliente válido.");
                    }
        
                    Cliente selectedClient = DataStore.CLIENTES.stream()
                            .filter(cliente -> cliente.getNombre().equals(selectedClientName))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
        
                    ArriendoCuota firstRental = DataStore.ARRIENDOS.values().stream()
                            .filter(arriendo -> arriendo.getCliente().equals(selectedClient))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("No se encontraron arriendos para el cliente seleccionado."));
        
                    CuotaArriendo firstUnpaidCuota = firstRental.getCuotas().stream()
                            .filter(cuota -> !cuota.isPagada())
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Todas las cuotas ya están pagadas."));
        
                    firstUnpaidCuota.pagarCuota();
        
                    JOptionPane.showMessageDialog(null, "Primera cuota pagada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }


class ClientInterface {

    public ClientInterface() {
        JFrame frame = new JFrame("Clientes");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JCheckBox activeCheckbox = new JCheckBox("¿Vigente?", true);

        JButton addButton = new JButton("Agregar");

        panel.add(new JLabel("Cédula:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nameField);
        panel.add(activeCheckbox);
        panel.add(new JLabel());
        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);

        // Add listeners here
        addButton.addActionListener(e -> {
            try {
                String cedula = idField.getText().trim();
                String nombre = nameField.getText().trim();
                boolean vigente = activeCheckbox.isSelected();

                if (cedula.isEmpty() || nombre.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos deben ser completados.");
                }

                Cliente nuevoCliente = new Cliente(cedula, nombre, vigente);
                DataStore.CLIENTES.add(nuevoCliente);

                // Notify listeners of change
                DataStore.notifyClientChangeListeners();

                JOptionPane.showMessageDialog(frame, "Cliente agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Clear fields after adding
                idField.setText("");
                nameField.setText("");
                activeCheckbox.setSelected(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

class PaymentInterface {

    public PaymentInterface() {
        JFrame frame = new JFrame("Pagar Cuotas Arriendos");
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JComboBox<String> clientDropdown = new JComboBox<>();
        JList<String> rentalList = new JList<>();
        JButton showPaymentsButton = new JButton("Mostrar pagos arriendo seleccionado >>");

        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(0, 1)); // Dynamically adjusts rows

        JButton payButton = new JButton("Realizar Pago");

        panel.add(new JLabel("Seleccione cliente:"));
        panel.add(clientDropdown);
        panel.add(new JLabel("Seleccione arriendo:"));
        panel.add(new JScrollPane(rentalList));
        panel.add(showPaymentsButton);
        panel.add(new JScrollPane(paymentPanel)); // Add dynamically generated checkboxes to scrollable panel
        panel.add(payButton);

        // Populate clientDropdown with client names
        for (Cliente cliente : DataStore.CLIENTES) {
            clientDropdown.addItem(cliente.getNombre());
        }
        
        // Add a listener to monitor changes to DataStore.CLIENTES
        DataStore.addClientChangeListener(evt -> {
            clientDropdown.removeAllItems();
            for (Cliente cliente : DataStore.CLIENTES) {
                clientDropdown.addItem(cliente.getNombre());
            }
        });

        frame.add(panel);
        frame.setVisible(true);

        // Add listeners here
        clientDropdown.addActionListener(e -> {
            String selectedClientName = (String) clientDropdown.getSelectedItem();
            if (selectedClientName != null) {
                DefaultListModel<String> rentalListModel = new DefaultListModel<>();
                DataStore.ARRIENDOS.values().stream()
                        .filter(arriendo -> arriendo.getCliente().getNombre().equals(selectedClientName))
                        .forEach(arriendo -> rentalListModel.addElement("Arriendo " + arriendo.getNumArriendo() + ": Vehículo: " + arriendo.getVehiculo().getPatente()));
                rentalList.setModel(rentalListModel);
            }
        });

        showPaymentsButton.addActionListener(e -> {
            try {
                // Fetch selected rental
                String selectedRentalInfo = rentalList.getSelectedValue();
                if (selectedRentalInfo == null) {
                    throw new IllegalArgumentException("No se seleccionó ningún arriendo.");
                }

                int selectedRentalId = Integer.parseInt(selectedRentalInfo.split(" ")[1].replace(":", ""));
                ArriendoCuota selectedRental = DataStore.ARRIENDOS.get(selectedRentalId);

                if (selectedRental == null) {
                    throw new IllegalArgumentException("No se encontró el arriendo seleccionado.");
                }

                // Clear previous data in paymentPanel
                paymentPanel.removeAll();

                // Display cuotas of the selected rental
                for (CuotaArriendo cuota : selectedRental.getCuotas()) {
                    JCheckBox cuotaCheckbox = new JCheckBox("Cuota " + cuota.getNumCuota() + ": $" + cuota.getValorCuota() + (cuota.isPagada() ? " (Pagada)" : ""));
                    cuotaCheckbox.setEnabled(!cuota.isPagada()); // Disable if already paid
                    paymentPanel.add(cuotaCheckbox);
                }

                paymentPanel.revalidate();
                paymentPanel.repaint();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        payButton.addActionListener(e -> {
            try {
                // Fetch selected rental
                String selectedRentalInfo = rentalList.getSelectedValue();
                if (selectedRentalInfo == null) {
                    throw new IllegalArgumentException("No se seleccionó ningún arriendo.");
                }

                int selectedRentalId = Integer.parseInt(selectedRentalInfo.split(" ")[1].replace(":", ""));
                ArriendoCuota selectedRental = DataStore.ARRIENDOS.get(selectedRentalId);

                if (selectedRental == null) {
                    throw new IllegalArgumentException("No se encontró el arriendo seleccionado.");
                }

                // Process payments for selected cuotas
                for (Component component : paymentPanel.getComponents()) {
                    if (component instanceof JCheckBox checkbox && checkbox.isSelected()) {
                        int cuotaNumber = Integer.parseInt(checkbox.getText().split(" ")[1].replace(":", ""));
                        CuotaArriendo cuota = selectedRental.getCuotas().stream()
                                .filter(c -> c.getNumCuota() == cuotaNumber)
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("No se encontró la cuota seleccionada."));

                        if (!cuota.isPagada()) {
                            cuota.pagarCuota();
                            checkbox.setText(checkbox.getText() + " (Pagada)");
                            checkbox.setEnabled(false);
                        }
                    }
                }

                paymentPanel.revalidate();
                paymentPanel.repaint();
                JOptionPane.showMessageDialog(frame, "Pagos realizados con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}


