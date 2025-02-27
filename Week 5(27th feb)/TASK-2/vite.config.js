import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from "path";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      "@f2": path.resolve(__dirname, "f2"), // ✅ Alias for f2 outside src
    },
  },
});
