   
    try {
 
            String newName = String.valueOf(txtName.getText());
            String nameNumberString;
            String name;
 
            long number;
            int index;
 

            File file = new File("C:\\Users\\sebpa\\OneDrive\\Escritorio\\UNAL\\POO\\friendsContact.txt");
 
            if (!file.exists()) {
 

                file.createNewFile();
            }
 

 
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
 

            while (raf.getFilePointer() < raf.length()) {
 

                nameNumberString = raf.readLine();
 

                String[] lineSplit
                    = nameNumberString.split("!");
 

                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 

                //System.out.println(
                    //"The contact name is : " + name + "\n"
                    //+ "The contact number is : " + number + "\n");
                
                        txtName.setText(String.valueOf(name));
                        txtNumber.setText(String.valueOf(number));
                
                found = true;
                
            }
            }
            catch (IOException ioe){
 
                System.out.println(ioe);
            }
            catch (NumberFormatException nef){
 
                System.out.println(nef);
            }    
