
        try {
            //String newName = data[0];
            String newName = String.valueOf(txtName.getText());
            //long newNumber = Long.parseLong(data[1]);
            long newNumber = Long.parseLong(txtNumber.getText());
            String nameNumberString;
            String name;
            long number;
            int index;
            
            File file = new File("C:\\Users\\sebpa\\OneDrive\\Escritorio\\UNAL\\POO\\friendsContact.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
 

 
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 

            while (raf.getFilePointer() < raf.length()) {
 

                nameNumberString = raf.readLine();
 

                String[] lineSplit
                    = nameNumberString.split("!");
 
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                if (name == newName
                    || number == newNumber) {
                    found = true;
                    break;
                }
            }
 
            if (found == false) {
 

                nameNumberString
                    = newName + "!"
                      + String.valueOf(newNumber);
 

                raf.writeBytes(nameNumberString);
 

                raf.writeBytes(System.lineSeparator());
 
                JOptionPane.showMessageDialog(null, " The friend " + newName+ " was added. ");
                //System.out.println(" The friend " + newName+ " was added. ");
 

                raf.close();
            }

            else {
 

                raf.close();
 

                System.out.println(" Input name"
                                   + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
 
            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {
 
            System.out.println(nef);
        }
